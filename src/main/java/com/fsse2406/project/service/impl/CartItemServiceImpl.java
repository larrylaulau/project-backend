package com.fsse2406.project.service.impl;

import com.fsse2406.project.data.user.domainObject.FirebaseUserData;
import com.fsse2406.project.data.user.entity.UserEntity;
import com.fsse2406.project.service.CartItemService;
import com.fsse2406.project.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class CartItemServiceImpl implements CartItemService {
    private final UserService userService;

    public CartItemServiceImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void putCartItem(Integer pid, Integer quantity, FirebaseUserData firebaseUserData) {
        UserEntity userEntity = userService.getUserEntityByFirebaseUserData(firebaseUserData);
    }
}
