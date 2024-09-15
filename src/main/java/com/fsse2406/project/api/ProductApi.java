package com.fsse2406.project.api;

import com.fsse2406.project.config.EnvConfig;
import com.fsse2406.project.data.product.Data.GetAllProductResponseData;
import com.fsse2406.project.data.product.Dto.GetAllProductResponseDto;
import com.fsse2406.project.data.product.Dto.ProductResponseDto;
import com.fsse2406.project.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin({EnvConfig.DEV_BASE_URL, EnvConfig.PROD_BASE_URL})
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
    public ProductResponseDto getProductById(@PathVariable Integer pid){
        return new ProductResponseDto(productService.getProductById(pid));

    }


}
