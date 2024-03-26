package com.icbc.sd.reflect;

import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestReflect {

    @Test
    void testCommon() {
        SomeService someService = new SomeService();
        someService.doSome();
        System.out.println(someService.doSome("张雨凝"));
        System.out.println(someService.doSome("张雨凝", 19));
    }

    @Test
    void testReflect() {
        try {
            Class<?> clazz = Class.forName("com.icbc.sd.reflect.SomeService");
            Method doSome = clazz.getDeclaredMethod("doSome", String.class, int.class);
            Object invoke = doSome.invoke(clazz.getConstructor().newInstance(), "张雨凝", 19);
            System.out.println(invoke);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void testNoArgs() {
        try {
            Class<?> clazz = Class.forName("com.icbc.sd.reflect.SomeService");
            Method doSome = clazz.getDeclaredMethod("doSome");
            Object o = clazz.getConstructor().newInstance();
            Object invoke = doSome.invoke(o);
            System.out.println(invoke);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void testDependencyInject() throws Exception {
        Class<?> clazz = Class.forName("com.icbc.sd.di.User");
        Method setAge = clazz.getDeclaredMethod("setAge", int.class);
        Object user = clazz.getConstructor().newInstance();
        Object user2 = clazz.getConstructor(int.class).newInstance(19);
        setAge.invoke(user, 18);
        System.out.println(user);
        System.out.println(user2);

    }
}
