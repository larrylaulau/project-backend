package com.fsse2406.project.data.product.Dto;

import java.math.BigDecimal;

public class ProductRequestDto {

    private int pid;
    private String Name;
    private String imageUrl;
    private BigDecimal Price;
    private int stock;

    public int getpId() {
        return pid;
    }

    public void setpId(int pId) {
        this.pid = pId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public BigDecimal getPrice() {
        return Price;
    }

    public void setPrice(BigDecimal price) {
        Price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
