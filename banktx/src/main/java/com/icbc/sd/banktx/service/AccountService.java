package com.icbc.sd.banktx.service;

public interface AccountService {

    void transfer(String from, String to, String amount);


    void saveAccount(String name, String amount);

    int deposit(String name, String amount);

}
