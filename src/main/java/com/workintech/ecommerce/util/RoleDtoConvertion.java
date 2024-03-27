package com.workintech.ecommerce.util;

import com.workintech.ecommerce.dto.RoleResponseDto;
import com.workintech.ecommerce.entity.Role;

import java.util.ArrayList;
import java.util.List;

public class RoleDtoConvertion {


    public static List<RoleResponseDto> convertRoleList(List<Role> roles){
        List<RoleResponseDto> roleResponses=new ArrayList<>();
        roles.stream().forEach(role ->
                roleResponses.add(new RoleResponseDto(role.getId(),role.getName()
                ,role.getCode())));
        return roleResponses;
    }

    public static RoleResponseDto convertRole(Role role){
        return new RoleResponseDto(role.getId(), role.getName(), role.getCode());
    }
}
