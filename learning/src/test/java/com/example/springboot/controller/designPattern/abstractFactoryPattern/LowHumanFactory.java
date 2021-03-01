package com.example.springboot.controller.designPattern.abstractFactoryPattern;

public class LowHumanFactory implements AbstractFactory{

    @Override
    public IBreakFast getEat() {
        System.out.println("Low 和牛奶");
        return  new MilkBreakFast();
    }

    @Override
    public ITraffic getTraffic() {
        System.out.println("Low 骑自行车");
        return  new BikeTraffic();
    }
}
