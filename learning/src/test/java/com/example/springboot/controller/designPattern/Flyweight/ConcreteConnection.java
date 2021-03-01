package com.example.springboot.controller.designPattern.Flyweight;

import lombok.Data;

@Data
public class ConcreteConnection implements Connection {

    private String driver;
    private String url;
    private String user;
    private String password;

    public ConcreteConnection(String driver, String url, String user, String password) {
        this.driver = driver;
        this.url = url;
        this.user = user;
        this.password = password;
    }

    @Override
    public void showInfo() {
        System.out.printf("Conn[driver=%s; url=%s; user=%s; password=%s]\n",
                driver, url, user, password);
    }
    // Getters and Setters
    // ...

    // 重写hashCode()
    // ...

    // 重写equals()：所有属性相等同返回true
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ConcreteConnection that = (ConcreteConnection) o;

        return (driver != null ? driver.equals(that.driver) : that.driver == null)
                && (url != null ? url.equals(that.url) : that.url == null)
                && (user != null ? user.equals(that.user) : that.user == null)
                && (password != null ? password.equals(that.password) : that.password == null);
    }

}
