package com.example.security.service.impl;

import com.example.security.mapper.PermissionMapper;
import com.example.security.model.Permission;
import com.example.security.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionServiceImpl implements IPermissionService {

    @Autowired
    PermissionMapper permissionMapper;

    @Override
    public List<Permission> selectByUserId(Integer id) {
        return permissionMapper.selectByUserId(id);
    }
}
