package com.workintech.ecommerce.service;

import com.workintech.ecommerce.dto.StoreResponseDto;
import com.workintech.ecommerce.entity.Store;

import java.util.List;

public interface StoreService {

    StoreResponseDto getStoreInfo(long id);

    StoreResponseDto addStore(Store store);

    List<StoreResponseDto> getStore();


}
