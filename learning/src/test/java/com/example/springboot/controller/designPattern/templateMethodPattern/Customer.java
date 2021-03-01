package com.example.springboot.controller.designPattern.templateMethodPattern;

public class Customer {

    private AbstractTemplate template;

    public Customer(AbstractTemplate template) {
        this.template = template;
    }

    public void showBill() {
        System.out.printf("the final bill costs %f\n", template.finalBill());
    }

}
