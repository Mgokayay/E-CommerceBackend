package com.workintech.ecommerce.service;

import com.workintech.ecommerce.dto.CategoriesResponseDto;
import com.workintech.ecommerce.entity.Categories;
import com.workintech.ecommerce.exception.CategoriesException;
import com.workintech.ecommerce.repository.CategoriesRepository;
import com.workintech.ecommerce.util.CategoryDtoConvertion;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriesServiceImpl implements CategoriesService {

   //TODO final durumunu hocaya sor
    private CategoriesRepository categoriesRepository;
    @Autowired
    public CategoriesServiceImpl(CategoriesRepository categoriesRepository) {
        this.categoriesRepository = categoriesRepository;
    }

    @Override
    public CategoriesResponseDto save(Categories categories) {
        //TODO return değerin için bir obje kullan(dto)
        Categories savedCategories= categoriesRepository.save(categories);
        return CategoryDtoConvertion.convertCategory(categories);
    }

    @Override
    public List<CategoriesResponseDto> findByAll() {
        List<Categories> categories = categoriesRepository.findAll();
        return CategoryDtoConvertion.convertCategoryList(categories);

    }

    @Override
    public CategoriesResponseDto delete(long id) {
        CategoriesResponseDto categoriesResponseDto = findById(id);
        categoriesRepository.deleteById(id);
        return categoriesResponseDto;


        // if(categoriesResponseDto != null){
       //     categoriesRepository.deleteById(id);
       //     return categoriesResponseDto;
       // }
       // return null;
    }

    @Override
    public CategoriesResponseDto findById(long id) {
        Optional<Categories> categoryOptional = categoriesRepository.findById(id);
        if(categoryOptional.isPresent()){
           Categories categories = categoryOptional.get();

            return CategoryDtoConvertion.convertCategory(categories);
        }
        //TODO burada error hangling yap.İlgili id de category olmadığına dair mesaj dön
        throw new CategoriesException("Category with given id is not exist: " + id, HttpStatus.NOT_FOUND);

    }
}

