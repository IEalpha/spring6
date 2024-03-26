package com.icbc.sd;

import com.icbc.sd.myspringtest.service.OrderService;
import org.junit.jupiter.api.Test;
import org.myspringframework.core.ApplicationContext;
import org.myspringframework.core.ClasspathXmlApplicationContext;

public class MyspringTest {
    @Test
    void testMySpring() {
        ApplicationContext ctx = new ClasspathXmlApplicationContext("spring.xml");
        OrderService orderService = (OrderService) ctx.getBean("orderService");
        orderService.insert();
        Object vip = ctx.getBean("vip");
        System.out.println("vip = " + vip);
    }
}
