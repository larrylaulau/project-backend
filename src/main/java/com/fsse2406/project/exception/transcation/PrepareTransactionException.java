package com.fsse2406.project.exception.transcation;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class PrepareTransactionException extends RuntimeException{
    public PrepareTransactionException(String msg) {
        super("Prepare Transaction Failed:" + msg);
    }
}
