package com.example.security.controller;

import com.example.security.model.Permission;
import com.example.security.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PermissionController {

    @Autowired
    IPermissionService permissionService;

    /*
     *     @PathVariable 是获取url上数据的。
     *         如果 url {} 中的名称与形参名称不一致，@PathVariable 需指定名称:@PathVariable(id)
     *     @RequestParam 获取请求参数的（包括post表单提交）
     *
     */
    @RequestMapping(value = "/getPermission/{id}", method = RequestMethod.GET)
    public List<Permission> selectByUserId(@PathVariable Integer id) {
        System.out.println("执行 selectByUserId ");
        List<Permission> permissionList = permissionService.selectByUserId(id);
        System.out.println(permissionList.toString());
        return permissionList;
    }



}
