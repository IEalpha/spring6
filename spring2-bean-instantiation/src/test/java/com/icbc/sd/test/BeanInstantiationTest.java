package com.icbc.sd.test;

import com.icbc.sd.beanInstantiation.SpringBean;
import com.icbc.sd.factoryBeanInstantiation.Cat;
import com.icbc.sd.factoryBeanInterfaceInstantiation.Gun;
import com.icbc.sd.factoryBeanInterfaceInstantiation.GunFactory;
import com.icbc.sd.simpleBeanFactoryInstantiation.Star;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanInstantiationTest {

    private static final Logger logger = LoggerFactory.getLogger(BeanInstantiationTest.class);

    @Test
    void testBeanInstantiation() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        SpringBean springBean = ctx.getBean("springBean", SpringBean.class);
        logger.info("springBean: {}", springBean);
    }


    @Test
    void testSimpleBeanFactoryInstantiation() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        Star star = ctx.getBean("star", Star.class);
        logger.info("star: {}", star);
    }


    @Test
    void testFactoryBeanInstantiation() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        Cat cat = ctx.getBean("cat", Cat.class);
        logger.info("cat: {}", cat);
    }

    @Test
    void testFactoryBeanInstantiation2() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        Gun gun = ctx.getBean("gun", Gun.class);
        GunFactory gunFactory = ctx.getBean("&gun", GunFactory.class);
        logger.info("gun: {}", gun);
        logger.info("gunFactory: {}", gunFactory);
    }
}
