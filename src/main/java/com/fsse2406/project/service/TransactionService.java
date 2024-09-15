package com.fsse2406.project.service;

import com.fsse2406.project.data.transcation.domainObject.TransactionResponseData;
import com.fsse2406.project.data.user.domainObject.request.FirebaseUserData;

public interface TransactionService {
    TransactionResponseData prepareTransaction (FirebaseUserData firebaseUserData);

    TransactionResponseData getTransactionByTid(FirebaseUserData firebaseUserData, Integer tid);

    boolean payTransaction(FirebaseUserData firebaseUserData, Integer tid);

    TransactionResponseData finishTransaction(FirebaseUserData firebaseUserData, Integer tid);
}
