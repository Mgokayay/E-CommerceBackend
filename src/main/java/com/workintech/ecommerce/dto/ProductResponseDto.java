package com.workintech.ecommerce.dto;

import com.workintech.ecommerce.entity.Store;

public record ProductResponseDto(Long id, String name, String description, double price, Long stock, String images, double rating,
                                 Store storeId, Long sellCount) {
}
