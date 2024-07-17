package com.fsse2406.project.api;

import com.fsse2406.project.data.user.domainObject.FirebaseUserData;
import com.fsse2406.project.service.CartItemService;
import com.fsse2406.project.util.JwtUtil;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Cart")
public class CartItemApi {

    private final CartItemService cartItemService;

    public CartItemApi(final CartItemService cartItemService) {
        this.cartItemService = cartItemService;
    }

    @PutMapping("/{pid}/{quantity}")
    public void putCartItem(JwtAuthenticationToken jwt,
                            @PathVariable Integer pid,
                            @PathVariable Integer quantity) {
        FirebaseUserData firebaseUserData = JwtUtil.getFirebaseUserData(jwt);
        cartItemService.putCartItem(pid,quantity, firebaseUserData);
    }

}
