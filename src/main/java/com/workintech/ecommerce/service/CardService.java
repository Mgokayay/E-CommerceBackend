package com.workintech.ecommerce.service;

import com.workintech.ecommerce.dto.CardResponseDto;
import com.workintech.ecommerce.entity.Card;

import java.util.List;

public interface CardService {

    CardResponseDto save(Card card);

    List<CardResponseDto> findByAll();

    CardResponseDto delete(Long id);

    CardResponseDto findById(Long id);
}
