package com.workintech.ecommerce.util;

import com.workintech.ecommerce.dto.CardResponseDto;
import com.workintech.ecommerce.entity.Card;

import java.util.ArrayList;
import java.util.List;

public class CardDtoConvertion {


    public static List<CardResponseDto> convertCardList(List<Card> cards){
        List<CardResponseDto> cardResponses=new ArrayList<>();
        cards.stream().forEach(card ->
                cardResponses.add(new CardResponseDto(card.getCardId(),
                        card.getCardNo(), card.getCardExpireMonth(), card.getCardExpireYear()
                        ,card.getCarCcv(),card.getCardName())));
        return cardResponses;
    }

    public static CardResponseDto convertCard(Card card){
        return new CardResponseDto(card.getCardId(),
                card.getCardNo(), card.getCardExpireMonth(), card.getCardExpireYear()
                ,card.getCarCcv(),card.getCardName());
    }
}
