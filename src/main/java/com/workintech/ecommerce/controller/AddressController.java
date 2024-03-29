package com.workintech.ecommerce.controller;


import com.workintech.ecommerce.dto.AddressResponseDto;
import com.workintech.ecommerce.entity.Address;
import com.workintech.ecommerce.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {

    private final AddressService addressService;
    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @PostMapping
    public AddressResponseDto save(@RequestBody Address address){
        return addressService.save(address);
    }

    @GetMapping
    public List<AddressResponseDto> findAll(){
        return addressService.findAll();
    }


    @GetMapping("/{id}")
    public AddressResponseDto findById(@PathVariable Long id){
        return addressService.findById(id);
    }

    @DeleteMapping("/{id}")
    public AddressResponseDto delete(@PathVariable Long id){
        return addressService.delete(id);
    }

}
