package com.example.security.model;

import lombok.Data;

@Data
public class Permission {

    private Integer id;
    // 父权限
    private Integer parentId;
    // 权限名称
    private String name;
    // 权限英文名称
    private String enname;
    // 授权路径
    private String url;
    // 备注
    private String description;

    private String created;

    private String updated;

}
