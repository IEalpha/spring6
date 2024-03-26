package com.icbc.sd.beanLifecycle;

import lombok.Getter;
import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

@Getter
public class User implements BeanNameAware, DisposableBean, InitializingBean {
    private String name;



    public User() {
        System.out.println("1. User's constructor");
    }

    public void setName(String name) {
        System.out.println("2. User's setName");
        this.name = name;
    }

    public void init() {
        System.out.println("6. User's init");
    }

    public void destroyBean() {
        System.out.println("10. User's destroy");
    }


    @Override
    public void setBeanName(String name) {
        System.out.println("3. User's setBeanName" + name);
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("9. User's destroy");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("5. User's afterPropertiesSet");
    }
}
