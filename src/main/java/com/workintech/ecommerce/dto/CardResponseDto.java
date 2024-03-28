package com.workintech.ecommerce.dto;

public record CardResponseDto(Long id,Long cardNo,Long cardExpireMonth,Long cardExpireYear,Long cardCcv,String cardName) {
}
