package com.workintech.ecommerce.controller;

import com.workintech.ecommerce.dto.ProductResponseDto;
import com.workintech.ecommerce.entity.Product;
import com.workintech.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class ProductsController {


    private final ProductService productService;
    @Autowired
    public ProductsController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ProductResponseDto save(@RequestBody Product product){
        return productService.save(product);
    }

    @GetMapping
    public List<ProductResponseDto> findAll(){
        return productService.findByAll();
    }

    @GetMapping("/{id}")
    public ProductResponseDto findById(@PathVariable Long id){
        return productService.findById(id);
    }

    @DeleteMapping("/{id}")
    public ProductResponseDto delete(@PathVariable Long id){
        return productService.delete(id);
    }

}
