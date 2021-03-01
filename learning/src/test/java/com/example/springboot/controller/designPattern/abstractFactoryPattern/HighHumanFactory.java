package com.example.springboot.controller.designPattern.abstractFactoryPattern;

public class HighHumanFactory implements AbstractFactory{


    @Override
    public IBreakFast getEat() {
        System.out.println("High 吃三明治");
        return new SandwichBreakFast();
    }

    @Override
    public ITraffic getTraffic() {
        System.out.println("High 坐公交");
        return new BusTraffic();
    }
}
