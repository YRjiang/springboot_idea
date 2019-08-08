package com.example.security.model;

import lombok.Data;

@Data
public class User {

    private Integer id;

    private String username;

    private String password;

    private String phone;

    private String email;

    private String created;

    private String updated;

}
