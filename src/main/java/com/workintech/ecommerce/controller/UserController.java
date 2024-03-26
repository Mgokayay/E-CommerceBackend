package com.workintech.ecommerce.controller;

import com.workintech.ecommerce.dto.UserResponseDto;
import com.workintech.ecommerce.entity.User;
import com.workintech.ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public UserResponseDto save(@RequestBody User user){
        return userService.addUser(user);
    }

    @GetMapping("/{id}")
    public UserResponseDto findById(@PathVariable Long id) {return userService.getUserById(id);}


    @GetMapping
    public List<UserResponseDto> findAll(){
        return userService.getAllUser();
    }

    @DeleteMapping
    public UserResponseDto delete(@PathVariable Long id){
        return userService.deleteUser(id);
    }
}
