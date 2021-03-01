package com.example.springboot.controller.designPattern.abstractFactoryPattern;

public class MilkBreakFast implements IBreakFast {
    @Override
    public void eat() {
        System.out.println("早餐喝牛奶");
    }
}
