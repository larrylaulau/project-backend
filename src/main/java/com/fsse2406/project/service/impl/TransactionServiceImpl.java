package com.fsse2406.project.service.impl;

import com.fsse2406.project.data.cartItem.entity.CartItemEntity;
import com.fsse2406.project.data.cartItem.status.TranscationStatus;
import com.fsse2406.project.data.transcation.domainObject.TransactionResponseData;
import com.fsse2406.project.data.transcation.entity.TransactionEntity;
import com.fsse2406.project.data.transactionProduct.entity.TransactionProductEntity;
import com.fsse2406.project.data.user.domainObject.request.FirebaseUserData;
import com.fsse2406.project.data.user.entity.UserEntity;
import com.fsse2406.project.exception.transcation.PayTransactionException;
import com.fsse2406.project.exception.transcation.PrepareTransactionException;
import com.fsse2406.project.exception.transcation.TransactionNotFoundException;
import com.fsse2406.project.repository.CartItemRepository;
import com.fsse2406.project.repository.TranscationRepository;
import com.fsse2406.project.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {
    private  final Logger logger = LoggerFactory.getLogger(TransactionServiceImpl.class);

    private final ProductService productService;
    private final UserService userService;
    private final CartItemService cartItemService;
    private final TransactionProductService transactionProductService;
    private final TranscationRepository transcationRepository;

    public TransactionServiceImpl(ProductService productService,
                                  UserService userService,
                                  CartItemService cartItemService,
                                  CartItemRepository cartItemRepository,
                                  TransactionProductService transactionProductService,
                                  TranscationRepository transcationRepository) {
        this.productService = productService;
        this.userService = userService;
        this.cartItemService = cartItemService;
        this.transactionProductService = transactionProductService;
        this.transcationRepository = transcationRepository;
    }

    public TransactionResponseData prepareTransaction(FirebaseUserData firebaseUserData) {
        try{
            UserEntity userEntity = userService.getUserEntityByFirebaseUserData(firebaseUserData);
            List<CartItemEntity> userCart = cartItemService.getEntityListByUser(userEntity);

            if(userCart.isEmpty()) {
                throw new PrepareTransactionException("Cart is empty");
            }

            TransactionEntity transactionEntity = new TransactionEntity(userEntity);
            transactionEntity = transcationRepository.save(transactionEntity);

            List<TransactionProductEntity>transactionProductEntityList = new ArrayList<>();
            BigDecimal total = BigDecimal.ZERO;

            for(CartItemEntity cartItemEntity: userCart){
                TransactionProductEntity transactionProductEntity =
                        transactionProductService.createTransactionProduct(transactionEntity, cartItemEntity);
                transactionProductEntityList.add(transactionProductEntity);
                total = total.add(
                        transactionProductEntity.getPrice().multiply(
                                new BigDecimal(transactionProductEntity.getQuantity())
                        )
                );
            }
            transactionEntity.setTotal(total);
            transactionEntity = transcationRepository.save(transactionEntity);
            return new TransactionResponseData(transactionEntity, transactionProductEntityList);
        }catch(Exception ex){
            logger.warn(ex.getMessage());
            throw ex;
        }
    }
@Override
    public TransactionResponseData getTransactionByTid(FirebaseUserData firebaseUserData, Integer tid){
        try{
            TransactionEntity transactionEntity = getEntityByTidAndFirebaseUid(tid, firebaseUserData.getFirebaseUid());
            List<TransactionProductEntity> transactionProductEntityList = transactionProductService.getEntityListByTransaction(transactionEntity);
            return new TransactionResponseData(transactionEntity, transactionProductEntityList);
        }catch(Exception ex){
            logger.warn("Get Transaction Failed: "+ ex.getMessage());
            throw ex;
        }

    }
@Override
    public boolean payTransaction(FirebaseUserData firebaseUserData, Integer tid){
        try{
            TransactionEntity transactionEntity = getEntityByTidAndFirebaseUid(tid, firebaseUserData.getFirebaseUid());

            if(transactionEntity.getStatus() != TranscationStatus.PREPARE){
                throw new PayTransactionException("Status Error!");
            }
            List<TransactionProductEntity> transactionProductEntityList =
                    transactionProductService.getEntityListByTransaction(transactionEntity);

            for(TransactionProductEntity transactionProductEntity: transactionProductEntityList){
                if(!productService.isValidQuantity(transactionProductEntity.getPid(), transactionProductEntity.getQuantity())){
                throw new PayTransactionException("Not Enough Stock!" + transactionProductEntity.getPid());
                }
            }
            for(TransactionProductEntity transactionProductEntity: transactionProductEntityList){
                productService.deduceStock(transactionProductEntity.getPid(), transactionProductEntity.getQuantity());
            }
            transactionEntity.setStatus(TranscationStatus.PROCESSING);
            transcationRepository.save(transactionEntity);
            return true;
        }catch(Exception ex){
            logger.warn("Pay Transaction Failed: "+ ex.getMessage());
            throw ex;
        }
    }
@Override
    public TransactionResponseData finishTransaction(FirebaseUserData firebaseUserData, Integer tid){
        TransactionEntity transactionEntity = getEntityByTidAndFirebaseUid(tid, firebaseUserData.getFirebaseUid());
        if(transactionEntity.getStatus() != TranscationStatus.PROCESSING){
            throw new PayTransactionException("Status Error!");
        }

        cartItemService.emptyUserCart(firebaseUserData.getFirebaseUid());
        transactionEntity.setStatus(TranscationStatus.SUCCESS);
        transcationRepository.save(transactionEntity);

        return new TransactionResponseData(
                transactionEntity, transactionProductService.getEntityListByTransaction(transactionEntity)
        );
    }

    public TransactionEntity getEntityByTidAndFirebaseUid(Integer tid, String firebaseUid){
        return transcationRepository.findByTidAndUser_FirebaseUid(tid, firebaseUid).orElseThrow(
                () -> new TransactionNotFoundException(tid,firebaseUid)
        );
    }

}
