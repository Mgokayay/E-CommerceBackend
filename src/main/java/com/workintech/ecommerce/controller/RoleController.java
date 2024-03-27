package com.workintech.ecommerce.controller;

import com.workintech.ecommerce.dto.RoleResponseDto;
import com.workintech.ecommerce.entity.Role;
import com.workintech.ecommerce.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleController {

    private final RoleService roleService;

    @Autowired
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @PostMapping
    public RoleResponseDto save(@RequestBody Role role){
        return roleService.addRole(role);
    }

    @GetMapping
    public List<RoleResponseDto> findAll(){
        return roleService.findAll();
    }

    @GetMapping("/{id}")
    public RoleResponseDto findById(@PathVariable Long id){
        return roleService.findRole(id);
    }

    @DeleteMapping
    public RoleResponseDto delete(@PathVariable Long id) {
        return roleService.deleteRole(id);
    }
}
