package com.workintech.ecommerce.service;

import com.workintech.ecommerce.dto.CategoriesResponseDto;
import com.workintech.ecommerce.entity.Categories;

import java.util.List;

public interface CategoriesService{

    CategoriesResponseDto save(Categories categories);

    List<CategoriesResponseDto> findByAll();

    CategoriesResponseDto delete(long id);

    CategoriesResponseDto findById(long id);




}
