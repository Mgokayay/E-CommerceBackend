package com.workintech.ecommerce.dto;

public record CategoriesResponseDto(Long id,String code,String title,String img,String gender,double rating) { //TODO double wrapper mı olmalı sor
}
