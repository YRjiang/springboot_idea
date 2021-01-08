package com.example.security.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class LoginInfo implements Serializable {

    private String name;
    private String avatar;

}
