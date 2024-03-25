package com.workintech.ecommerce.util;

import com.workintech.ecommerce.dto.ProductResponseDto;
import com.workintech.ecommerce.entity.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductDtoConvertion {

    public static List<ProductResponseDto> convertProductList(List<Product> products){
        List<ProductResponseDto> productResponses=new ArrayList<>();
        products.stream().forEach(product ->
                productResponses.add(new ProductResponseDto(product.getId(),product.getName(),
                        product.getDescription(),product.getPrice(),
                        product.getStock(),product.getImages(),
                        product.getRating(),product.getStoreId(),product.getSellCount())));
                        return productResponses;
    }
    public static ProductResponseDto convertProduct(Product product){
        return new ProductResponseDto(product.getId(),product.getName(),
                product.getDescription(),product.getPrice(),
                product.getStock(),product.getImages(),
                product.getRating(),product.getStoreId(),product.getSellCount());
    }
}
