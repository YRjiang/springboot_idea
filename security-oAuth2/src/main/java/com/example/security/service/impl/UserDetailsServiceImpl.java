package com.example.security.service.impl;

import com.example.security.model.Permission;
import com.example.security.service.IUserService;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private IUserService userService;

    @Autowired
    private PermissionServiceImpl permissionService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 查询用户信息
        com.example.security.model.User user = userService.getUserByname(username);
        List<GrantedAuthority> grantedAuthorities = Lists.newArrayList();
        if (user != null) {
            // 获取用户授权
            List<Permission> tbPermissions = permissionService.selectByUserId(user.getId());

            // 声明用户授权
            tbPermissions.forEach(tbPermission -> {
                if (tbPermission != null && tbPermission.getEnname() != null) {
                    GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(tbPermission.getEnname());
                    grantedAuthorities.add(grantedAuthority);
                }
            });
        }

        // 由框架完成认证工作
        return new User(user.getUsername(), user.getPassword(), grantedAuthorities);
    }

}
