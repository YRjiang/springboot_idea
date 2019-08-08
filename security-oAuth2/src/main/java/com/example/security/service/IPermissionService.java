package com.example.security.service;

import com.example.security.model.Permission;

import java.util.List;

public interface IPermissionService {

    List<Permission> selectByUserId(Integer id);

}
