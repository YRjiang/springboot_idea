package com.example.springboot.controller.designPattern.templateMethodPattern;

public class Client {

    public static void main(String[] args) {
        // 模拟会员结账
        Customer counter = new Customer(new ConcreteTemplateB());
        counter.showBill();
    }

}
