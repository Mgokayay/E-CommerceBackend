package com.workintech.ecommerce.service;

import com.workintech.ecommerce.dto.AddressResponseDto;
import com.workintech.ecommerce.entity.Address;
import com.workintech.ecommerce.exception.AddressException;
import com.workintech.ecommerce.repository.AddressRepository;
import com.workintech.ecommerce.util.AdressDtoConvertion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressServiceImpl implements AddressService{


    private final AddressRepository addressRepository;
    @Autowired
    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public AddressResponseDto save(Address address) {
        Address savedAddress=addressRepository.save(address);
        return AdressDtoConvertion.convertAddress(address);
    }

    @Override
    public List<AddressResponseDto> findAll() {
        List<Address> address=addressRepository.findAll();
        return AdressDtoConvertion.convertAddressList(address);
    }

    @Override
    public AddressResponseDto delete(Long id) {
        AddressResponseDto addressResponseDto=findById(id);
        addressRepository.deleteById(id);
        return addressResponseDto;
    }

    @Override
    public AddressResponseDto findById(Long id) {
        Optional<Address> addressOptional = addressRepository.findById(id);
        if(addressOptional.isPresent()){
            return AdressDtoConvertion.convertAddress(addressOptional.get());
        }
        throw new AddressException("Address with given id is not exist " + id, HttpStatus.NOT_FOUND);
    }
}
