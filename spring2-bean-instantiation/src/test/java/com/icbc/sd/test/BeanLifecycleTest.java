package com.icbc.sd.test;

import com.icbc.sd.beanLifecycle.User;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifecycleTest {
    @Test
    void testBeanLifecycle() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("lifecycle.xml");
        User user = ctx.getBean("user", User.class);
        System.out.println("8. bean's usage ... =>" + user);
        ctx.close();
    }
}
