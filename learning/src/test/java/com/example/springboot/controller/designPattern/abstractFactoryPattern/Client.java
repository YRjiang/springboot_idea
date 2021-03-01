package com.example.springboot.controller.designPattern.abstractFactoryPattern;

/**
 * 抽象工厂模式
 * 两个 interface （即两个产品）
 * productA 型号1 型号2
 * productB 型号1 型号2
 * (productA productB 组合一起才形成一个完整的)
 * 两个 interface （即两个工厂）
 * factoryA 生产 productA 型号1 productB 型号1
 * factoryB 生产 productA 型号2 productB 型号2
 * 客户端 需要哪种组合就去工厂取
 *
 */
public class Client {

    public static void main(String[] args) {
        AbstractFactory human = new LowHumanFactory();
        System.out.println("这个人： ");
        human.getEat().eat();
        human.getTraffic().leave();
    }

}
