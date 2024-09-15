package com.fsse2406.project.api;

import com.fsse2406.project.config.EnvConfig;
import com.fsse2406.project.data.transactionProduct.dto.response.TransactionSuccessResponseDto;
import com.fsse2406.project.data.transcation.domainObject.TransactionResponseData;
import com.fsse2406.project.data.transcation.dto.response.TransactionResponseDto;
import com.fsse2406.project.data.user.domainObject.request.FirebaseUserData;
import com.fsse2406.project.service.TransactionService;
import com.fsse2406.project.util.JwtUtil;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transaction")
@CrossOrigin({EnvConfig.DEV_BASE_URL, EnvConfig.PROD_BASE_URL})

public class TransactionApi {
    private final TransactionService transactionService;

    public TransactionApi(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping("/prepare")
    public TransactionResponseDto prepareTransaction (JwtAuthenticationToken token){
        TransactionResponseData responseData = transactionService.prepareTransaction(JwtUtil.getFirebaseUserData(token));
        return new TransactionResponseDto(responseData);
    }

    @GetMapping("/{tid}")
    public TransactionResponseDto getTransactionByTid (JwtAuthenticationToken token,
                                                       @PathVariable Integer tid){
        FirebaseUserData firebaseUserData = JwtUtil.getFirebaseUserData(token);
        TransactionResponseData transactionResponseData = transactionService.getTransactionByTid(firebaseUserData, tid);
        TransactionResponseDto transactionResponseDto = new TransactionResponseDto(transactionResponseData);
        return transactionResponseDto;
    }

    @PatchMapping("/{tid}/pay")
    public TransactionSuccessResponseDto payTransaction (JwtAuthenticationToken token,
                                                         @PathVariable Integer tid){
        FirebaseUserData firebaseUserData = JwtUtil.getFirebaseUserData(token);
        transactionService.payTransaction(firebaseUserData, tid);
        return new TransactionSuccessResponseDto();
    }

    @PatchMapping("/{tid}/finish")
    public TransactionResponseDto finishTransactionByPid (JwtAuthenticationToken token,
                                                          @PathVariable Integer tid){
        FirebaseUserData firebaseUserData = JwtUtil.getFirebaseUserData(token);
        TransactionResponseData transactionResponseData =
                transactionService.finishTransaction(firebaseUserData, tid);
        TransactionResponseDto transactionResponseDto = new TransactionResponseDto(transactionResponseData);
        return transactionResponseDto;
    }
}
