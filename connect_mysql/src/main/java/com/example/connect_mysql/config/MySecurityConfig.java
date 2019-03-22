package com.example.connect_mysql.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        // 定制请求的授权规则  --  authorizeRequests(授权请求 匹配)
        http.authorizeRequests().antMatchers("/").permitAll()
                // 请求 /city/** 需要 cityOwner 角色的权限
                .antMatchers("/city/**").hasRole("cityOwner")
                .antMatchers("/user/**").hasRole("userOwner");
        // 开启自动配置 登入功能
        http.formLogin();
        //1. 登入页     /login
        //2. 登入失败   /login?error
        //3. 详情规定

        // 开启自动配置 注销功能
        http.logout().logoutSuccessUrl("/");
        //1. 注销用户，清空session  /logout
        //2. 注销成功返回   /login?logout

        // 开启记住账号功能
        http.rememberMe();
        // 登入成功，将 cookie 发送给浏览器保存， 之后登入将带上这个 cookie，自动登入
        // 注销，将删除 cookie

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // 定义认证规则  -- inMemoryAuthentication (内存) 也可以在数据库中
        //              -- passwordEncoder 增加了多种加密方式，也改变了密码的格式  BCryptPasswordEncoder
        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
                .withUser("zhangsan").password(new BCryptPasswordEncoder().encode("123456"))
                .roles("cityOwner")
                .and()
                .withUser("lisi").password(new BCryptPasswordEncoder().encode("123123"))
                .roles("userOwner");
    }
}
