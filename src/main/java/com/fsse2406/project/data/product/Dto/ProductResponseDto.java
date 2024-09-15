package com.fsse2406.project.data.product.Dto;

import com.fsse2406.project.data.product.Data.ProductResponseData;
import com.fsse2406.project.data.transactionProduct.domainObject.TransactionProductResponseData;

import java.math.BigDecimal;

public class ProductResponseDto {
    private int pid;
    private String Name;
    private String imageUrl;
    private BigDecimal Price;
    private int stock;
    private String description;

    public ProductResponseDto(ProductResponseData data) {
        this.pid = data.getPid();
        this.Name = data.getName();
        this.imageUrl = data.getImageUrl();
        this.Price = data.getPrice();
        this.stock = data.getStock();
        this.description = data.getDescription();
    }

    public ProductResponseDto(TransactionProductResponseData data) {
        this.pid = data.getPid();
        this.Name = data.getName();
        this.imageUrl = data.getImageUrl();
        this.Price = data.getPrice();
        this.stock = data.getStock();
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

