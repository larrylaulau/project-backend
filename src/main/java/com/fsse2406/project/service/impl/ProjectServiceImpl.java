package com.fsse2406.project.service.impl;


import com.fsse2406.project.data.product.Data.ProductResponseData;
import com.fsse2406.project.data.product.Entity.ProductEntity;
import com.fsse2406.project.repository.ProductRepository;
import com.fsse2406.project.exception.ProductNotFoundException;
import com.fsse2406.project.service.ProjectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProjectServiceImpl implements ProjectService {
    Logger logger = LoggerFactory.getLogger(ProjectServiceImpl.class);

    private final ProductRepository productRepository;

    public ProjectServiceImpl(ProductRepository productRepository) {
     this.productRepository = productRepository;
 }

 @Override
public List<ProductResponseData> getAllProduct(){
        List<ProductResponseData> productResponseDataList = new ArrayList<>();

        for(ProductEntity entity : productRepository.findAll()){
            productResponseDataList.add(new ProductResponseData(entity));
        }
        return productResponseDataList;
}
@Override
public ProductEntity getProductEntityById(int pid) {


        Optional<ProductEntity> optionalProductEntityentity = productRepository.findById(pid);
        if (optionalProductEntityentity.isPresent()) {
            return optionalProductEntityentity.get();
        }throw new ProductNotFoundException(pid);

    }
}


