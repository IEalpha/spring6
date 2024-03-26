package com.icbc.sd.dynamic.client.jdk;

import com.icbc.sd.dynamic.service.OrderService;
import com.icbc.sd.dynamic.service.OrderServiceImpl;
import com.icbc.sd.dynamic.utils.MyInvocationHandle;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Client {
    public static void main(String[] args) {
        OrderService orderService = new OrderServiceImpl();
        MyInvocationHandle myInvocationHandle = new MyInvocationHandle(orderService);
        OrderService proxy1 = (OrderService) Proxy.newProxyInstance(orderService.getClass().getClassLoader(), new Class[]{OrderService.class}, myInvocationHandle);
        OrderService proxy2 = (OrderService) Proxy.newProxyInstance(orderService.getClass().getClassLoader(), orderService.getClass().getInterfaces(), myInvocationHandle);
        proxy1.insert();
        proxy2.update();
        proxy2.query();
        proxy2.delete();
    }
}
