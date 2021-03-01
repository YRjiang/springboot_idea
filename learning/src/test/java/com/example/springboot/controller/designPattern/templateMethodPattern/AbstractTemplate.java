package com.example.springboot.controller.designPattern.templateMethodPattern;

// 抽象账单
public abstract class AbstractTemplate {

    protected double getTotal() {
        return 1000; // 模拟一个原始总价
    }
    protected abstract double cost(); // 此方法由具体模板实现

    // 模板方法：计算最后总价
    public final double finalBill() {
        return cost();
    }

}
