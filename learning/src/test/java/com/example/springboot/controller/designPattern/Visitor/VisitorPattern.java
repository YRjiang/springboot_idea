package com.example.springboot.controller.designPattern.Visitor;

import java.util.ArrayList;
import java.util.List;

public class VisitorPattern {

    public static void main(String[] args) {
        Client client = new Client();
        client.method();
    }

}

/**
 * 节点
 */
// 抽象节点
interface Node {
    void accept(Visitor visitor); // 声明一个方法，接收一个访问者对象作为参数
}
// 具体节点A
class NodeA implements Node {
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void method() {
        System.out.println("this is Node A");
    }
}
// 具体节点B
class NodeB implements Node {
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void method() {
        System.out.println("this is Node B");
    }
}
// 具体节点C
class NodeC implements Node {
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void method() {
        System.out.println("this is Node C");
    }
}


/**
 * 访问者
 */
// 抽象访问者，针对不同的节点对象声明不同的方法
interface Visitor {
    void visit(NodeA node);
    void visit(NodeB node);
    void visit(NodeC node);
}
//
class ConcreteVisitor implements Visitor {
    @Override
    public void visit(NodeA node) {
        node.method();
    }

    @Override
    public void visit(NodeB node) {
        node.method();
    }

    @Override
    public void visit(NodeC node) {
        node.method();
    }
}

/**
 * 结构对象
 */

class Structure {
    private List<Node> nodes = new ArrayList<>();

    // 由访问者代替数据结构访问具体的实现逻辑
    public void action(Visitor visitor) {
        nodes.forEach(node -> node.accept(visitor)); // 遍历自身
    }

    public void add(Node node) {
        nodes.add(node);
    }
}

/**
 * 客户
 */
class Client {
    public void method() {
        Structure structure = new Structure();
        structure.add(new NodeA());
        structure.add(new NodeB());
        structure.add(new NodeC());
        structure.action(new ConcreteVisitor());
    }
}