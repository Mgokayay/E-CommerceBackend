package com.workintech.ecommerce.util;

import com.workintech.ecommerce.dto.StoreResponseDto;
import com.workintech.ecommerce.entity.Store;

import java.util.ArrayList;
import java.util.List;

public class StoreDtoConvertion {

    public static List<StoreResponseDto> convertStoreList(List<Store> stores){
        List<StoreResponseDto> storeResponses=new ArrayList<>();
        stores.stream().forEach(store ->
                storeResponses.add(new StoreResponseDto(store.getId(),
                        store.getName(),store.getPhone(),
                        store.getTaxNo(),store.getBankAccount(),
                        store.getUserId())));
                        return storeResponses;
    }

    public static StoreResponseDto convertStore(Store store){
        return new StoreResponseDto(store.getId(),store.getName()
        ,store.getPhone(),store.getTaxNo()
        ,store.getBankAccount(),store.getUserId());
    }
}
