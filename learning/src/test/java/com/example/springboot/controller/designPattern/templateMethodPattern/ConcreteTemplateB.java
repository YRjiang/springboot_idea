package com.example.springboot.controller.designPattern.templateMethodPattern;

// 会员账单
public class ConcreteTemplateB extends AbstractTemplate{

    @Override
    public double cost() {
        return getTotal()*0.88; // 88折
    }

}
