package com.icbc.sd.dynamic.utils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvocationHandle implements InvocationHandler {

    private final Object target;

    public MyInvocationHandle(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        long start = System.currentTimeMillis();
        Object invoke = method.invoke(target, args);
        long end = System.currentTimeMillis();
        System.out.println(method.getName() + "耗时：" + (end - start));
        return invoke;
    }
}
