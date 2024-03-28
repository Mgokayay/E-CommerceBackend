package com.workintech.ecommerce.controller;

import com.workintech.ecommerce.dto.CardResponseDto;
import com.workintech.ecommerce.entity.Card;
import com.workintech.ecommerce.repository.CardRepository;
import com.workintech.ecommerce.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/card")
public class CardController {

    private final CardService cardService;
    @Autowired
    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    @PostMapping
    public CardResponseDto save(@RequestBody Card card){
        return cardService.save(card);
    }

    @GetMapping
    public List<CardResponseDto> findAll(){
        return cardService.findByAll();
    }
    @GetMapping("/{id}")
    public CardResponseDto findById(@PathVariable Long id){
        return cardService.findById(id);
    }
    @DeleteMapping("/{id}")
    public CardResponseDto delete(@PathVariable Long id){
        return cardService.delete(id);
    }

}
