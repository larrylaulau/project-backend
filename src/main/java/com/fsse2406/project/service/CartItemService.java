package com.fsse2406.project.service;

import com.fsse2406.project.data.user.domainObject.FirebaseUserData;

public interface CartItemService {
    void putCartItem(Integer pid, Integer quantity, FirebaseUserData firebaseUserData);
}
