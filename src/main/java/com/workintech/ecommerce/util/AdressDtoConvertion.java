package com.workintech.ecommerce.util;

import com.workintech.ecommerce.dto.AddressResponseDto;
import com.workintech.ecommerce.entity.Address;

import java.util.ArrayList;
import java.util.List;

public class AdressDtoConvertion {


    public static List<AddressResponseDto> convertAddressList(List<Address> addresses){
        List<AddressResponseDto> addressResponses=new ArrayList<>();
        addresses.stream().forEach(address ->
                addressResponses.add(new AddressResponseDto(address.getId(),
                        address.getTitle(),address.getName(),address.getPhone()
                ,address.getCity(),address.getDistrict(),address.getNeighborhood(),address.getAddress())));
        return addressResponses;
    }
    public static AddressResponseDto convertAddress(Address address){
        return new AddressResponseDto(address.getId(),
                address.getTitle(),address.getName(),address.getPhone()
                ,address.getCity(),address.getDistrict(),address.getNeighborhood(),address.getAddress());
    }
}
