package com.workintech.ecommerce.dto;

public record UserResponseDto(Long id,String name,String email,String password,Long roleId) {
}
