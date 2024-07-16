package com.fsse2406.project.service;

import com.fsse2406.project.data.product.Data.ProductResponseData;
import com.fsse2406.project.data.product.Entity.ProductEntity;

import java.util.List;

public interface ProjectService {

    List<ProductResponseData> getAllProduct();

    ProductEntity getProductEntityById(int pid);
}
