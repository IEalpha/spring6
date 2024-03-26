package com.icbc.sd.beanLifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class LogBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("4. LogBeanPostProcessor's postProcessBeforeInitialization" + beanName + " " + bean.getClass());
        return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("7. LogBeanPostProcessor's postProcessAfterInitialization" + beanName + " " + bean.getClass());
        return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }
}
