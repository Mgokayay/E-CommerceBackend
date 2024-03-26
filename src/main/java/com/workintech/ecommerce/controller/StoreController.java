package com.workintech.ecommerce.controller;

import com.workintech.ecommerce.dto.StoreResponseDto;
import com.workintech.ecommerce.entity.Store;
import com.workintech.ecommerce.service.StoreService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/store")
public class StoreController {

    private final StoreService storeService;


    public StoreController(StoreService storeService) {
        this.storeService = storeService;
    }
    @PostMapping
    public StoreResponseDto save(@RequestBody Store store){
        return storeService.addStore(store);
    }

    @GetMapping
    public List<StoreResponseDto> findAll(){
        return storeService.getStore();
    }

    @GetMapping("/{id}")
    public StoreResponseDto findById(@PathVariable Long id){
        return storeService.getStoreInfo(id);
    }
}
