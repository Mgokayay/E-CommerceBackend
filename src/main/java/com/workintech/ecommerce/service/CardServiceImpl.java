package com.workintech.ecommerce.service;

import com.workintech.ecommerce.dto.CardResponseDto;
import com.workintech.ecommerce.entity.Card;
import com.workintech.ecommerce.exception.CardException;
import com.workintech.ecommerce.repository.CardRepository;
import com.workintech.ecommerce.util.CardDtoConvertion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CardServiceImpl implements CardService{

    private final CardRepository cardRepository;
    @Autowired
    public CardServiceImpl(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    @Override
    public CardResponseDto save(Card card) {
        Card savedCard = cardRepository.save(card);
        return CardDtoConvertion.convertCard(card);
    }

    @Override
    public List<CardResponseDto> findByAll() {
        List<Card> card = cardRepository.findAll();
        return CardDtoConvertion.convertCardList(card);

    }
    @Override
    public CardResponseDto findById(Long id) {
        Optional<Card> cardOptional = cardRepository.findById(id);
        if(cardOptional.isPresent()){
            return CardDtoConvertion.convertCard(cardOptional.get());
        }
        throw new CardException("Card with given id is not exist " + id, HttpStatus.NOT_FOUND);
    }

    @Override
    public CardResponseDto delete(Long id) {
        CardResponseDto cardResponseDto=findById(id);
        cardRepository.deleteById(id);
        return cardResponseDto;
    }

}
