package com.workintech.ecommerce.service;

import com.workintech.ecommerce.dto.RoleResponseDto;
import com.workintech.ecommerce.entity.Role;

import java.util.List;

public interface RoleService {
    List<RoleResponseDto> findAll();

    RoleResponseDto findRole(Long id);

    RoleResponseDto addRole(Role role);

    RoleResponseDto deleteRole(Long id);
}
