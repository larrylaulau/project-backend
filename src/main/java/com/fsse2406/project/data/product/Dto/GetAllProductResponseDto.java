package com.fsse2406.project.data.product.Dto;

import com.fsse2406.project.data.product.Data.GetAllProductResponseData;

import java.math.BigDecimal;

public class GetAllProductResponseDto {
    private int pid;
    private String Name;
    private String imageUrl;
    private BigDecimal Price;
    private boolean hasStock;


    public GetAllProductResponseDto(GetAllProductResponseData getAllProductResponseData) {
        this.pid = getAllProductResponseData.getPid();
        this.Name = getAllProductResponseData.getName();
        this.imageUrl = getAllProductResponseData.getImageUrl();
        this.Price = getAllProductResponseData.getPrice();
        this.hasStock = getAllProductResponseData.getStock()>0;

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

    public boolean isHasStock() {
        return hasStock;
    }

    public void setHasStock(boolean hasStock) {
        this.hasStock = hasStock;
    }

}
