package com.example.security.mapper;

import com.example.security.model.Permission;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PermissionMapper {

    List<Permission> selectByUserId(Integer id);
}
