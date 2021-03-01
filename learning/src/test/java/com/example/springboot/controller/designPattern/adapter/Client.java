package com.example.springboot.controller.designPattern.adapter;

public class Client {

    // 类适配器
    /*public static void main(String[] args) {
        ClassAdapter adapter = new ClassAdapter();
        adapter.method1();
        adapter.method2();
    }*/

    // 对象适配器
    public static void main(String[] args) {
        ObjectAdapter adapter = new ObjectAdapter(new Adaptee());
        adapter.method1();
        adapter.method2();
    }

}
