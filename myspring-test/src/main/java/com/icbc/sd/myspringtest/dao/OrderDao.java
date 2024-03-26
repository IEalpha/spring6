package com.icbc.sd.myspringtest.dao;

import lombok.Getter;

@Getter
public class OrderDao {
    public void insert() {
        System.out.println("正在创建订单...");
    }
}
