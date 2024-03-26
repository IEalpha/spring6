package com.icbc.sd.factoryBeanInterfaceInstantiation;


import org.springframework.beans.factory.FactoryBean;

public class GunFactory implements FactoryBean<Gun> {

    public GunFactory() {
        System.out.println("GunFactory constructor");
    }

    @Override
    public Gun getObject() throws Exception {
        return new Gun();
    }

    @Override
    public Class<?> getObjectType() {
        return Gun.class;
    }
}
