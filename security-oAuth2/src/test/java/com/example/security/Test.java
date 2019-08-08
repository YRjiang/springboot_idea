package com.example.security;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Test {

    @org.junit.Test
    public void passwordEncode() {
        System.out.println("secret 加密：" + new BCryptPasswordEncoder().encode("qwer"));
        System.out.println("解密2：" + new BCryptPasswordEncoder().encode("123456"));
    }
}
