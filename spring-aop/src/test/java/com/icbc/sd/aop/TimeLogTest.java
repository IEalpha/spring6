package com.icbc.sd.aop;

import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TimeLogTest {
    @Test
    void testLog() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        long sum = context.getBean(UserService.class).addUser();
        System.out.println(sum);
    }
}
