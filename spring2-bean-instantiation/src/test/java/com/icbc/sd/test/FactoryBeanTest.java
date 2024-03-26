package com.icbc.sd.test;

import com.icbc.sd.factoryBeanUsage.Student;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FactoryBeanTest {
    @Test
    void testDate() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext2.xml");
        Student student = ctx.getBean("student", Student.class);
        System.out.println("student = " + student);
    }
}
