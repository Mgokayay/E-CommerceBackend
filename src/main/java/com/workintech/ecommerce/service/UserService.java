package com.workintech.ecommerce.service;

import com.workintech.ecommerce.dto.UserResponseDto;
import com.workintech.ecommerce.entity.User;

import java.util.List;

public interface UserService {

    List<UserResponseDto> getAllUser ();

    UserResponseDto addUser(User user);

    UserResponseDto getUserById(Long id);

    UserResponseDto deleteUser(Long id);




}
