package com.example.springboot.controller.designPattern.abstractFactoryPattern;

public class SandwichBreakFast implements IBreakFast {
    @Override
    public void eat() {
        System.out.println("早餐吃三明治");
    }
}
