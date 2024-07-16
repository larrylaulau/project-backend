package com.fsse2406.project.data.product.Entity;

import com.fsse2406.project.data.product.Data.ProductRequestData;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name="Product")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pid;

    @Column(name="name", nullable = false)
    private String name;
    @Column(name="image_url")
    private String image_url;
    @Column(name="price")
    private BigDecimal price;
    @Column(name="stock", nullable = false)
    private int stock;

    public ProductEntity() {
    }

    public ProductEntity(ProductRequestData data) {
        this.pid = data.getPid();
        this.name = data.getName();
        this.image_url = data.getImage_url();
        this.price = data.getPrice();
        this.stock = data.getStock();
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

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
