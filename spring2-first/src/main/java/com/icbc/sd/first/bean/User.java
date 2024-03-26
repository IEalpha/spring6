package com.icbc.sd.first.bean;

public class User {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("User's setName()...");
        this.name = name;
    }

    public User(String name) {
        System.out.println("User's constructor...");
        this.name = name;
    }

    public User() {
        System.out.println("User's no args constructor...");
    }
}
