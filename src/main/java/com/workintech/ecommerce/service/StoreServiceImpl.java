package com.workintech.ecommerce.service;

import com.workintech.ecommerce.dto.StoreResponseDto;
import com.workintech.ecommerce.entity.Store;

import com.workintech.ecommerce.exception.StoreException;
import com.workintech.ecommerce.repository.StoreRepository;

import com.workintech.ecommerce.util.StoreDtoConvertion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StoreServiceImpl implements StoreService{


    private final StoreRepository storeRepository;

    @Autowired
    public StoreServiceImpl(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    @Override
    public StoreResponseDto getStoreInfo(long id) {
        Optional<Store> storeOptional = storeRepository.findById(id);
        if(storeOptional.isPresent()){

            return StoreDtoConvertion.convertStore(storeOptional.get());
        }
        throw new StoreException("Store with given id is not exist" +id, HttpStatus.NOT_FOUND);
    }

    @Override
    public StoreResponseDto addStore(Store store) {
        Store savedStore=storeRepository.save(store);
        return StoreDtoConvertion.convertStore(store);
    }

    @Override
    public List<StoreResponseDto> getStore() {
        List<Store> store=storeRepository.findAll();
        return StoreDtoConvertion.convertStoreList(store);
    }
}
