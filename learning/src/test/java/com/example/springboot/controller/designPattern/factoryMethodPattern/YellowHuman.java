package com.example.springboot.controller.designPattern.factoryMethodPattern;

public class YellowHuman implements Human{
    @Override
    public void getColor() {
        System.out.println("黄种人");
    }

    @Override
    public void talk() {
        System.out.println("黄人说话");
    }
}
