package com.example.springboot.controller.designPattern.factoryMethodPattern;

public class WhiteHuman implements Human {

    @Override
    public void getColor() {
        System.out.println("白种人");
    }

    @Override
    public void talk() {
        System.out.println("白种人说话");
}
}
