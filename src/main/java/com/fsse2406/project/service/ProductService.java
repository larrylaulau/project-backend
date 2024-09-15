package com.fsse2406.project.service;

import com.fsse2406.project.data.product.Data.GetAllProductResponseData;
import com.fsse2406.project.data.product.Data.ProductResponseData;
import com.fsse2406.project.data.product.Entity.ProductEntity;

import java.util.List;

public interface ProductService {


    List<GetAllProductResponseData> getAllProduct();

    ProductResponseData getProductById(int id);

    ProductEntity getProductEntityById(int pid);

    boolean isValidQuantity(Integer pid, Integer quantity);

    boolean deduceStock(Integer pid, Integer quantity);
}
