package com.example.springboot.controller.designPattern.abstractFactoryPattern;

public class BusTraffic implements ITraffic {
    @Override
    public void leave() {
        System.out.println("早上出行方式： 公交");
    }
}
