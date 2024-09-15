package com.fsse2406.project.data.cartItem.dto.response;

import com.fsse2406.project.data.cartItem.domainObject.response.CartItemResponseData;

import java.math.BigDecimal;

public class CartItemResponseDto {
    private int pid;
    private String name;
    private String imageUrl;
    private BigDecimal price;
    private int cartQuantity;
    private int stock;

    public CartItemResponseDto(CartItemResponseData data) {
        this.pid = data.getProduct().getPid();
        this.name = data.getProduct().getName();
        this.imageUrl = data.getProduct().getImageUrl();
        this.price = data.getProduct().getPrice();
        this.cartQuantity = data.getQuantity();
        this.stock = data.getProduct().getStock();
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getCartQuantity() {
        return cartQuantity;
    }

    public void setCartQuantity(int cartQuantity) {
        this.cartQuantity = cartQuantity;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}