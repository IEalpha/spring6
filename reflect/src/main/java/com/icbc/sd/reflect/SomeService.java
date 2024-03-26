package com.icbc.sd.reflect;

public class SomeService {

    public void doSome() {
        System.out.println("doSome() is called.");
    }

    public String doSome(String s) {
        System.out.println("doSome(String s) is called.");
        return s;
    }

    public String doSome(String s, int i) {
        System.out.println("doSome(String s, int i) is called.");
        return s + i;
    }
}
