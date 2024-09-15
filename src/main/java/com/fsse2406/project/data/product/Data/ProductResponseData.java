package com.fsse2406.project.data.product.Data;

import com.fsse2406.project.data.product.Entity.ProductEntity;

import java.math.BigDecimal;

public class ProductResponseData {

    private int pid;
    private String Name;
    private String imageUrl;
    private BigDecimal Price;
    private int stock;
    private String description;

    public ProductResponseData(ProductEntity entity) {
        this.pid = entity.getPid();
        this.Name = entity.getName();
        this.imageUrl = entity.getImageUrl();
        this.Price = entity.getPrice();
        this.stock = entity.getStock();
        this.description = entity.getDescription();
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
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

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
}

