package com.icbc.sd.dynamic.service;

public class OrderServiceImpl implements OrderService{
    @Override
    public void insert() {
        try {
            Thread.sleep(1568);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("正在生成订单...");
    }

    @Override
    public void update() {
        try {
            Thread.sleep(2345);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("正在修改订单...");
    }

    @Override
    public void query() {
        try {
            Thread.sleep(333);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("正在查询订单...");
    }

    @Override
    public void delete() {
        try {
            Thread.sleep(765);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("正在删除订单...");
    }
}
