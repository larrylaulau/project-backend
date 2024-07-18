package com.fsse2406.project.api;

import com.fsse2406.project.data.product.Data.GetAllProductResponseData;
import com.fsse2406.project.data.product.Data.ProductResponseData;
import com.fsse2406.project.data.product.Dto.GetAllProductResponseDto;
import com.fsse2406.project.data.product.Dto.ProductResponseDto;
import com.fsse2406.project.service.ProductService;
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


    private final ProductService productService;
    @Autowired
    public ProductApi(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/getAllProduct")
    public List<GetAllProductResponseDto> getAllProduct(){
        List<GetAllProductResponseData> getAllproductResponseDataList = productService.getAllProduct();
        List<GetAllProductResponseDto> getAllProductResponseDtoList = new ArrayList<>();

        for(GetAllProductResponseData getAllProductResponseData : getAllproductResponseDataList){
            getAllProductResponseDtoList.add(new GetAllProductResponseDto(getAllProductResponseData));

        }
        return getAllProductResponseDtoList;

    }

    @GetMapping("/{pid}")
    public ProductResponseDto getProductById(@PathVariable int pid){
        return new ProductResponseDto(productService.getProductById(pid));

    }


}
