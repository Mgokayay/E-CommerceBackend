package com.workintech.ecommerce.util;

import com.workintech.ecommerce.dto.CategoriesResponseDto;
import com.workintech.ecommerce.entity.Categories;

import java.util.ArrayList;
import java.util.List;

public class CategoryDtoConvertion {


    public static List<CategoriesResponseDto> convertCategoryList(List<Categories> categories){
        List<CategoriesResponseDto> categoryResponses = new ArrayList<>();
        categories.stream().forEach(categories1 ->
                categoryResponses.add(new CategoriesResponseDto(categories1.getId(),categories1.getCode(),
                        categories1.getTitle(),categories1.getImg(),categories1.getGender(),categories1.getRating())));//TODO categories in alınacak değerleri parantez içerisinde
                        return categoryResponses;
    }

    public static CategoriesResponseDto convertCategory(Categories categories){
        return new CategoriesResponseDto(categories.getId(), categories.getCode(),categories.getTitle(),
                categories.getImg(),categories.getGender(),categories.getRating());//TODO parantez içine alınacak değerleri yazacağım
    }
}
