package com.fsse2406.project.data.product.Data;

import com.fsse2406.project.data.product.Entity.ProductEntity;

import java.math.BigDecimal;

public class ProductResponseData {

    private int pid;
    private String Name;
    private String image_url;
    private BigDecimal Price;
    private int stock;

    public ProductResponseData(ProductEntity entity) {
        this.pid = entity.getPid();
        this.Name = entity.getName();
        this.image_url = entity.getImage_url();
        this.Price = entity.getPrice();
        this.stock = entity.getStock();
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

