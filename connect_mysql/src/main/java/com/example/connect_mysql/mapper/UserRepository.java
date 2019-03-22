package com.example.connect_mysql.mapper;

import com.example.connect_mysql.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {    //实体类名  主键类型

    User findByName(String name);

}
