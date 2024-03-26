package com.workintech.ecommerce.util;

import com.workintech.ecommerce.dto.UserResponseDto;
import com.workintech.ecommerce.entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserDtoConvertion {


    public static List<UserResponseDto> convertUserList(List<User> users){
        List<UserResponseDto> userResponses=new ArrayList<>();
        users.stream().forEach(user ->
                userResponses.add(new UserResponseDto(user.getId()
                ,user.getName(), user.getEmail(), user.getPassword(),user.getRoleId())));
        return userResponses;
    }

    public static UserResponseDto convertUser(User user){
        return new UserResponseDto(user.getId(), user.getName(),
                user.getEmail(), user.getPassword(), user.getRoleId() );
    }
}
