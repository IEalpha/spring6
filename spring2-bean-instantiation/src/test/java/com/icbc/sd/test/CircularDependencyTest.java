package com.icbc.sd.test;

import com.icbc.sd.singletonAndSetModelCircularDependency.Wife;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CircularDependencyTest {

    @Test
    void testCircularDependency() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("circularDependency.xml");
        Wife wife = ctx.getBean("wife", Wife.class);
        System.out.println(wife);
        ctx.close();
    }
}
