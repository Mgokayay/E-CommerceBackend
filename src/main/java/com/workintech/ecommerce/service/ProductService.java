package com.workintech.ecommerce.service;

import com.workintech.ecommerce.dto.ProductResponseDto;
import com.workintech.ecommerce.entity.Product;

import java.util.List;

public interface ProductService {


    ProductResponseDto save(Product product);

    List<ProductResponseDto> findByAll();

    ProductResponseDto delete(long id);

    ProductResponseDto findById(long id);
}
