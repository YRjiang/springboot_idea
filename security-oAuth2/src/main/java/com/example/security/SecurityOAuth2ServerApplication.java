package com.example.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 认证服务器，用于获取 Token
 * <p>
 * Description:
 * </p>
 *
 * @author Lusifer
 * @version v1.0.0
 * @date 2019-04-01 16:06:45
 * @see
 */
@SpringBootApplication
//@MapperScan("com.example.security.mapper")  //或者在 mapper 方法上加上 @Mapper
public class SecurityOAuth2ServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecurityOAuth2ServerApplication.class, args);
    }

}
