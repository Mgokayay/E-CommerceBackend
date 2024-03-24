package com.workintech.ecommerce.repository;

import com.workintech.ecommerce.entity.Categories;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriesRepository extends JpaRepository<Categories,Long> {
}
