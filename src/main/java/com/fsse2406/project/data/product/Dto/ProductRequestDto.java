package com.fsse2406.project.data.product.Dto;

import java.math.BigDecimal;

public class ProductRequestDto {

    private int pid;
    private String Name;
    private String image_url;
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

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
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
