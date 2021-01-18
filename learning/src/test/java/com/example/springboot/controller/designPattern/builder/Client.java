package com.example.springboot.controller.designPattern.builder;

import com.alibaba.fastjson.JSONObject;

/**
 * 客户类
 */
public class Client {

    public static void main(String[] args) {
        Builder builder = new ConcreteBuilder2();
        Director director = new Director(builder);
        Product product = director.construct();
        System.out.println("product: " + JSONObject.toJSONString(product));

    }

    /**
     *  1. 产品
     *  2. 抽象建造者
     *  3. 具体建造者
     *  4. 指挥官
     *  5. 客户类 - 1. new 一个具体建造者 2. new 一个带有建造目标的指挥官 3. 指挥官建造对应产品
     *
     */

}
