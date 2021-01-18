package com.example.springboot.controller.designPattern.builder;

/**
 * 具体建造者：实现了抽象建造者接口。
 */
public class ConcreteBuilder2 extends Builder {

    public void buildPartA() {
        product.setPartA("生产 PartA");
    }
    public void buildPartB() {
        product.setPartB("生产 PartB");
    }
    public void buildPartC() {
        product.setPartC("生产 PartC");
    }

}
