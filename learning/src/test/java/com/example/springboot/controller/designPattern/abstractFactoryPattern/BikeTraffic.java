package com.example.springboot.controller.designPattern.abstractFactoryPattern;

public class BikeTraffic implements ITraffic{
    @Override
    public void leave() {
        System.out.println("早上出行方式：自行车");
    }
}
