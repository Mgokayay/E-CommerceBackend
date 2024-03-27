package com.workintech.ecommerce.service;

import com.workintech.ecommerce.dto.RoleResponseDto;
import com.workintech.ecommerce.entity.Role;
import com.workintech.ecommerce.exception.RoleException;
import com.workintech.ecommerce.repository.RoleRepository;
import com.workintech.ecommerce.util.RoleDtoConvertion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService{

    private final RoleRepository roleRepository;
    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public List<RoleResponseDto> findAll() {
        List<Role> role= roleRepository.findAll();
        return RoleDtoConvertion.convertRoleList(role);
    }

    @Override
    public RoleResponseDto findRole(Long id) {
        Optional<Role> roleOptional = roleRepository.findById(id);
        if(roleOptional==null){
            return RoleDtoConvertion.convertRole(roleOptional.get());
        }
        throw new RoleException("Role with given id is not exist " +id, HttpStatus.NOT_FOUND);
    }

    @Override
    public RoleResponseDto addRole(Role role) {
        Role savedRole = roleRepository.save(role);
        return RoleDtoConvertion.convertRole(role);
    }

    @Override
    public RoleResponseDto deleteRole(Long id) {
        RoleResponseDto roleResponseDto=findRole(id);
        roleRepository.deleteById(id);
        return roleResponseDto;
    }
}
