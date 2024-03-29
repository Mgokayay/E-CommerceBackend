package com.workintech.ecommerce.service;

import com.workintech.ecommerce.dto.AddressResponseDto;
import com.workintech.ecommerce.entity.Address;

import java.util.List;

public interface AddressService {

    AddressResponseDto save(Address address);

    List<AddressResponseDto> findAll();

    AddressResponseDto delete(Long id);

    AddressResponseDto findById(Long id);
}
