package com.icbc.sd.dynamic.service;

public class LoginService {

    public boolean login(String username, String password) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("正在登录...");
        return "admin".equals(username) && "123".equals(password);
    }
}
