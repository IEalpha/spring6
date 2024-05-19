package com.icbc.sd.mybatis.service;

public interface AccountService {

    void transfer(String from, String to, String amount);
}
