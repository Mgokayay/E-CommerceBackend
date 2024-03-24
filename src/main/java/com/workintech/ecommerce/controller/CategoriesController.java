package com.workintech.ecommerce.controller;

import com.workintech.ecommerce.dto.CategoriesResponseDto;
import com.workintech.ecommerce.entity.Categories;
import com.workintech.ecommerce.service.CategoriesService;
import com.workintech.ecommerce.util.CategoryDtoConvertion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/categories")
@CrossOrigin(origins = "http://localhost:8585")
//TODO CORS hatası için yazdığımız kod
public class CategoriesController {

    private final CategoriesService categoriesService;
    @Autowired
    public CategoriesController(CategoriesService categoriesService) {
        this.categoriesService = categoriesService;
    }

    @PostMapping
    public CategoriesResponseDto save(@RequestBody Categories categories) {

        //TODO dto yapılacak
         return categoriesService.save(categories);
    }
    @GetMapping
    public List<CategoriesResponseDto> findAll(){

        return categoriesService.findByAll();
    }

    @GetMapping("/{id}")
    public CategoriesResponseDto findById(@PathVariable Long id){
        return categoriesService.findById(id);
    }

    @DeleteMapping("/{id}")
    public CategoriesResponseDto delete(@PathVariable Long id){
        return categoriesService.delete(id);
    }
//TODO validation ekle,unit test yaz,frontendinle backendini birbirine yaz,Cors hatası alınacak iyi deneyimle öğren




}
