package com.workintech.ecommerce.service;

import com.workintech.ecommerce.dto.ProductResponseDto;
import com.workintech.ecommerce.entity.Product;

import com.workintech.ecommerce.exception.ClassesException;
import com.workintech.ecommerce.repository.ProductRepository;
import com.workintech.ecommerce.util.ProductDtoConvertion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{


    private ProductRepository productRepository;
    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {

        this.productRepository = productRepository;
    }

    @Override
    public ProductResponseDto save(Product product) {
        Product savedProduct= productRepository.save(product);
        return ProductDtoConvertion.convertProduct(product);
    }

    @Override
    public List<ProductResponseDto> findByAll() {
        List<Product> products=productRepository.findAll();
        return ProductDtoConvertion.convertProductList(products);
    }

    @Override
    public ProductResponseDto delete(long id) {
        ProductResponseDto productResponseDto=findById(id);
        productRepository.deleteById(id);
        return productResponseDto;
    }

    @Override
    public ProductResponseDto findById(long id) {
        Optional<Product> productOptional = productRepository.findById(id);
        if(productOptional.isPresent()){
            Product product = productOptional.get();
            return ProductDtoConvertion.convertProduct(product);
        }
        throw new ClassesException("Product with given id is not exist: " + id, HttpStatus.NOT_FOUND);
    }


    //    @Override
//    public ProductResponseDto save(Long categoryID, Product product) {
//        //1 Category id ile ilgili Category bul.
//       Category category = categoryService.getCategoriesByID(categoryID);
//       //2. categorynin product listesini yeni product i ekle.
//        category.addProduct(product);
//        //3 . Product a category i ekle
//        product.setCategory(category);
//        //4. product i save et.
//        Product savedProduct = productRepository.save(product);
////        return new ProductResponseDto()
//        return null;
//    }
    //
}
