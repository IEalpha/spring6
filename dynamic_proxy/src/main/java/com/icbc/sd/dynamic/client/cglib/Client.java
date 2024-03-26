package com.icbc.sd.dynamic.client.cglib;

import com.icbc.sd.dynamic.service.LoginService;
import com.icbc.sd.dynamic.service.OrderService;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class Client {

    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(LoginService.class);

        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
                long start = System.currentTimeMillis();
                Object result = proxy.invokeSuper(obj, args);
                long end = System.currentTimeMillis();
                System.out.println(method.getName() + "耗时：" + (end - start));
                return result;
            }
        });

        LoginService loginService = (LoginService) enhancer.create();
        boolean success = loginService.login("admin", "123");
        System.out.println(success? "登录成功": "登录失败");

    }
}
