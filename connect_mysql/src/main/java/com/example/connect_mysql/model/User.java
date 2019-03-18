package com.example.connect_mysql.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;

@Table(name = "user")
@Entity
@Data
public class User {

    @Id
    @GeneratedValue
    private Integer id;

    private  String name;
    private  String password;

}
