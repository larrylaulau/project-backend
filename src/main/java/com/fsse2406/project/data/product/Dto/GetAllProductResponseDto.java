package com.fsse2406.project.data.product.Dto;

import com.fsse2406.project.data.product.Data.ProductResponseData;

import java.math.BigDecimal;

public class GetAllProductResponseDto {
    private int pid;
    private String Name;
    private String image_url;
    private BigDecimal Price;
    private boolean hasStock;

    public GetAllProductResponseDto(ProductResponseData productResponseData) {
        this.pid = productResponseData.getPid();
        this.Name = productResponseData.getName();
        this.image_url = productResponseData.getImage_url();
        this.Price = productResponseData.getPrice();
        this.hasStock = productResponseData.getStock()>0 ;
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

    public boolean isHasStock() {
        return hasStock;
    }

    public void setHasStock(boolean hasStock) {
        this.hasStock = hasStock;
    }
}
