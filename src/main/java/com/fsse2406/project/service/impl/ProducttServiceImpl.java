package com.fsse2406.project.service.impl;


import com.fsse2406.project.data.product.Data.GetAllProductResponseData;
import com.fsse2406.project.data.product.Data.ProductResponseData;
import com.fsse2406.project.data.product.Entity.ProductEntity;
import com.fsse2406.project.repository.ProductRepository;
import com.fsse2406.project.exception.ProductNotFoundException;
import com.fsse2406.project.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProducttServiceImpl implements ProductService {
    Logger logger = LoggerFactory.getLogger(ProducttServiceImpl.class);

    private final ProductRepository productRepository;

    public ProducttServiceImpl(ProductRepository productRepository) {
     this.productRepository = productRepository;
 }

 @Override
public List<GetAllProductResponseData> getAllProduct(){
        List<GetAllProductResponseData> getAllProductResponseDataList = new ArrayList<>();

        for(ProductEntity entity : productRepository.findAll()){
            getAllProductResponseDataList.add(new GetAllProductResponseData(entity));
        }
        return getAllProductResponseDataList;
}
@Override
public ProductResponseData getProductById(int pid){
        try{
            return new ProductResponseData(getProductEntityById(pid));
        }catch(Exception ex){
            logger.warn("Get Product by Pid:" + ex.getMessage());
            throw ex;
    }
}


@Override
public ProductEntity getProductEntityById(int pid) {


       return productRepository.findById(pid).orElseThrow(
               () ->new ProductNotFoundException(pid)
       );


    }
}


