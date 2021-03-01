package com.example.springboot.controller.designPattern.factoryMethodPattern;

/**
 *
 * 一个抽象产品 interface
 * 多个具体产品 class
 * 一个抽象工厂 interface
 * 多个具体工厂 class （一个具体工厂生产一个产品）
 * 客户new 具体的工厂 生产对应的产品
 *
 */
public class Client {

    public static void main(String[] args) {
        HumanFactory humanFactory = new HumanFactory();
        Human yellowHuman = humanFactory.createHuman(YellowHuman.class);
        yellowHuman.getColor();
    }

}
