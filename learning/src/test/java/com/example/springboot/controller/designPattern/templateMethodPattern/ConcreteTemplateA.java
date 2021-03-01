package com.example.springboot.controller.designPattern.templateMethodPattern;

// 非会员账单
public class ConcreteTemplateA extends AbstractTemplate {

    @Override
    public double cost() {
        return getTotal(); // 原价
    }

}
