package com.example.springboot.controller.designPattern.factoryMethodPattern;

public class BlackHuman implements Human {
    @Override
    public void getColor() {
        System.out.println("黑人");
    }

    @Override
    public void talk() {
        System.out.println("黑人说话");
    }
}
