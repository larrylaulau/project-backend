package com.fsse2406.project.data.cartItem.domainObject.response;

import com.fsse2406.project.data.cartItem.entity.CartItemEntity;
import com.fsse2406.project.data.product.Data.ProductResponseData;
import com.fsse2406.project.data.product.Entity.ProductEntity;
import com.fsse2406.project.data.user.domainObject.response.UserResponseData;
import com.fsse2406.project.data.user.entity.UserEntity;

public class CartItemResponseData {
    private int cid;
    private ProductResponseData product;
    private UserResponseData user;
    private int quantity;

    public CartItemResponseData(CartItemEntity cartItemEntity) {
        this.cid = cartItemEntity.getCid();
        this.product = new ProductResponseData(cartItemEntity.getProduct());
        this.user = new UserResponseData(cartItemEntity.getUser());
        this.quantity = cartItemEntity.getQuantity();
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public ProductResponseData getProduct() {
        return product;
    }

    public void setProduct(ProductResponseData product) {
        this.product = product;
    }

    public UserResponseData getUser() {
        return user;
    }

    public void setUser(UserResponseData user) {
        this.user = user;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
