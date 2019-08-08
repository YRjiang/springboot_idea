package com.example.security.config;

import com.example.security.service.impl.UserDetailsServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * 服务器安全配置
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        // 设置默认的加密方式
        return new BCryptPasswordEncoder();
    }

    /**
     * Spring Security 5.0 之前版本的 PasswordEncoder 接口默认实现为 NoOpPasswordEncoder 此时是可以使用明文密码的，
     * 在 5.0 之后默认实现类改为 DelegatingPasswordEncoder 此时密码必须以加密形式存储。
     *
     * @param auth
     * @throws Exception
     */
    /*@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()// 在内存中创建用户并为密码加密
                .withUser("admin").password(passwordEncoder().encode("123456")).roles("ADMIN")
                .and()
                .withUser("user").password(passwordEncoder().encode("123456")).roles("USER");
    }*/


    // 将 自定义的 UserDetailsService 注入容器
    @Bean
    @Override
    public UserDetailsService userDetailsService() {
        return new UserDetailsServiceImpl();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // 使用自定义认证与授权
        auth.userDetailsService(userDetailsService());
    }

    /**
     * 资源服务器需要访问 /oauth/check_token 端点来检查 access_token 的有效性，
     * 此时该端点是受保护的资源，当我们访问该端点时会遇到 403 问题，将该端点暴露出来即可
     * @param web
     * @throws Exception
     */
    @Override
    public void configure(WebSecurity web) throws Exception {
        // 将 check_token 暴露出去，否则资源服务器访问时报 403 错误
        web.ignoring().antMatchers("/oauth/check_token");
    }
}
