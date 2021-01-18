package com.example.springboot.controller.designPattern.builder;

import lombok.Data;

/**
 * 产品角色：包含多个组成部件的复杂对象。
 */
@Data
public class Product {

    private String partA;
    private String partB;
    private String partC;

    private void show() {
        //显示产品的特性
        System.out.println("展示产品属性： A: " + partA + ", B: " + partB + ", C: " + partC);
    }

}
