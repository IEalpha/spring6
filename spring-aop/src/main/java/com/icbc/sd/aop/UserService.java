package com.icbc.sd.aop;

public class UserService {
    public long addUser() {
        int count = 0;
        for (int i = 0; i < 100000; i++) {
            count += i;
        }
        System.out.println("add user" + count);
        return count;
    }
}
