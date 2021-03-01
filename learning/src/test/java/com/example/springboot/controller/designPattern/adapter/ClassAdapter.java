package com.example.springboot.controller.designPattern.adapter;

public class ClassAdapter extends Adaptee implements Target {

    @Override
    public void method2() {
        System.out.println("method 2");
    }

}
