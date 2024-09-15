package com.fsse2406.project.exception.transcation;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class TransactionNotFoundException extends RuntimeException{
    public TransactionNotFoundException(Integer tid, String firebaseUid){
        super(String.format("Transaction Not Found - tid:%d, firebaseUid:%s",tid ,firebaseUid));
    }
}
