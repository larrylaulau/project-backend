package com.fsse2406.project.api;

import com.fsse2406.project.data.product.Data.ProductResponseData;
import com.fsse2406.project.data.product.Dto.ProductResponseDto;
import com.fsse2406.project.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductApi {


    private final ProjectService projectService;
    @Autowired
    public ProductApi(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping("/getAllProduct")
    public List<ProductResponseDto> getAllProduct(){
        List<ProductResponseData> productResponseDataList = projectService.getAllProduct();
        List<ProductResponseDto> productResponseDtoList = new ArrayList<>();

        for(ProductResponseData productResponseData : productResponseDataList){
            productResponseDtoList.add(new ProductResponseDto(productResponseData));


        }
        return productResponseDtoList;

    }

    @GetMapping("/{id}")
    public ProductResponseDto getProductEntityById(@PathVariable int pid){
        ProductResponseData data = new ProductResponseData(projectService.getProductEntityById(pid));
        ProductResponseDto productResponseDto = new ProductResponseDto(data);
        return productResponseDto;
    }


}
