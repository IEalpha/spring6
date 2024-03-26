package com.icbc.sd.myspringtest.service;

import com.icbc.sd.myspringtest.dao.OrderDao;

public class OrderService {
    private OrderDao orderDao;

    public void setOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    public void insert() {
        System.out.println("OrderService insert");
        orderDao.insert();
    }
}
