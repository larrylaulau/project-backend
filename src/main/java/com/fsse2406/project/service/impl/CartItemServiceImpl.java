package com.fsse2406.project.service.impl;

import com.fsse2406.project.data.cartItem.domainObject.response.CartItemResponseData;
import com.fsse2406.project.data.cartItem.entity.CartItemEntity;
import com.fsse2406.project.data.product.Entity.ProductEntity;
import com.fsse2406.project.data.user.domainObject.request.FirebaseUserData;
import com.fsse2406.project.data.user.entity.UserEntity;
import com.fsse2406.project.exception.cartItem.CartItemException;
import com.fsse2406.project.repository.CartItemRepository;
import com.fsse2406.project.service.CartItemService;
import com.fsse2406.project.service.ProductService;
import com.fsse2406.project.service.UserService;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CartItemServiceImpl implements CartItemService {
    private static final Logger logger = LoggerFactory.getLogger(CartItemServiceImpl.class);

    private final UserService userService;
    private final ProductService productService;
    private final CartItemRepository cartItemRepository;

    public CartItemServiceImpl(UserService userService, ProductService productService, CartItemRepository cartItemRepository) {
        this.userService = userService;
        this.productService = productService;
        this.cartItemRepository = cartItemRepository;
    }


    @Override
    @Transactional
    public boolean putCartItem(Integer pid, Integer quantity, FirebaseUserData firebaseUserData) {

        try{
            UserEntity userEntity = userService.getUserEntityByFirebaseUserData(firebaseUserData);
            ProductEntity productEntity = productService.getProductEntityById(pid);

            if (quantity <= 0) {
                throw new CartItemException("quantity must be greater then 0");
            }

            Optional<CartItemEntity> optionalCartItemEntity = cartItemRepository.findByProductAndUser(productEntity, userEntity);
            if (optionalCartItemEntity.isEmpty()) {
                validateQuantity(quantity, productEntity.getStock());
                CartItemEntity cartItemEntity = new CartItemEntity(productEntity, userEntity, quantity);
                cartItemRepository.save(cartItemEntity);
            }else{
                CartItemEntity cartItemEntity = optionalCartItemEntity.get();
                cartItemEntity.setQuantity(cartItemEntity.getQuantity() + quantity);
                validateQuantity(quantity, productEntity.getStock());
            }
            return true;
        }catch(Exception ex){
            logger.warn("put item fail :"+ ex.getMessage());
            throw ex;
        }
    }
@Override
    public List<CartItemResponseData>getUserCart(FirebaseUserData firebaseUserData) {
        UserEntity loginUser = userService.getUserEntityByFirebaseUserData(firebaseUserData);
        List<CartItemResponseData> cartItemResponseDataList = new ArrayList<>();

        for (CartItemEntity cartItemEntity : cartItemRepository.findAllByUser(loginUser)) {
            cartItemResponseDataList.add(new CartItemResponseData(cartItemEntity));
        }
        return cartItemResponseDataList;
    }

    @Override
    @Transactional
    public CartItemResponseData updateQuantity(Integer pid, Integer quantity, FirebaseUserData firebaseUserData) {
       try {
           UserEntity userEntity = userService.getUserEntityByFirebaseUserData(firebaseUserData);
           ProductEntity productEntity = productService.getProductEntityById(pid);
           CartItemEntity cartItemEntity = getEntityByProductAndUser(productEntity, userEntity);

           validateQuantity(quantity, productEntity.getStock());

           cartItemEntity.setQuantity(quantity);
           return new CartItemResponseData(cartItemEntity);

       }catch(Exception ex){
           logger.warn("update cart item fail :"+ ex.getMessage());
           throw ex;
       }

    }
@Override
@Transactional
    public boolean removeCartItem(Integer pid, FirebaseUserData firebaseUserData) {
        Integer deleteCount = cartItemRepository.removeByProduct_PidAndUser_FirebaseUid(pid, firebaseUserData.getFirebaseUid());
        if(deleteCount <= 0) {
            throw new CartItemException("delete cart item fail pid :" + pid );
        }
        return true;
    }

    public CartItemEntity getEntityByProductAndUser(ProductEntity productEntity, UserEntity userEntity) {
        return cartItemRepository.findByProductAndUser(productEntity, userEntity).orElseThrow(
                () -> new CartItemException("Cart Item not found" + productEntity.getPid())
        );
    }

@Override
    public List<CartItemEntity>getEntityListByUser(UserEntity userEntity) {
        return cartItemRepository.findAllByUser(userEntity);
    }

    public void validateQuantity(Integer quantity, Integer stock) {
        if (quantity > stock) {
            throw new CartItemException("quantity must be smaller then stock");
        }
    }
@Override
@Transactional
    public void emptyUserCart(String firebaseUid) {
        cartItemRepository.deleteAllByUser_FirebaseUid(firebaseUid);
    }
}
