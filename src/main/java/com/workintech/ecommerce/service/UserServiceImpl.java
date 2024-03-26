package com.workintech.ecommerce.service;


import com.workintech.ecommerce.dto.UserResponseDto;
import com.workintech.ecommerce.entity.User;


import com.workintech.ecommerce.exception.UserException;
import com.workintech.ecommerce.repository.UserRepository;
import com.workintech.ecommerce.util.UserDtoConvertion;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{


    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserResponseDto> getAllUser() {
        List<User> user = userRepository.findAll();
        return UserDtoConvertion.convertUserList(user);
    }

    @Override
    public UserResponseDto addUser(User user) {
        User savedUser = userRepository.save(user);
        return UserDtoConvertion.convertUser(user);
    }

    @Override
    public UserResponseDto getUserById(Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        if(userOptional.isPresent()){
            return UserDtoConvertion.convertUser(userOptional.get());
        }
        throw new UserException("User with given id is not exist " +id, HttpStatus.NOT_FOUND);
    }

    @Override
    public UserResponseDto deleteUser(Long id) {
        UserResponseDto userResponseDto = getUserById(id);
        userRepository.deleteById(id);
        return userResponseDto;
    }




}
