package com.fsse2406.project.data.product.Data;

import com.fsse2406.project.data.product.Dto.ProductRequestDto;

import java.math.BigDecimal;

public class ProductRequestData {

    private int pid;
    private String Name;
    private String imageUrl;
    private BigDecimal Price;
    private int stock;
    private String description;

    public ProductRequestData(ProductRequestDto dto){
        this.pid=dto.getpId();
        this.Name=dto.getName();
        this.imageUrl =dto.getImageUrl();
        this.Price=dto.getPrice();
        this.stock=dto.getStock();
        this.description=dto.getDescription();
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
