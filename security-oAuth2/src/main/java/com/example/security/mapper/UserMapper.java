package com.example.security.mapper;

import com.example.security.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {

    int insert(User user);

    void deleteUserById(@Param("id") Integer id);

    void updateUser(User user);

    List<User> selectUsers();

    User getUserByname(String username);
}
