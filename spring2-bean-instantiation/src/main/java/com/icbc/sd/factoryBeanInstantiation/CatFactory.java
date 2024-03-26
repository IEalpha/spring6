package com.icbc.sd.factoryBeanInstantiation;


public class CatFactory {

    public CatFactory() {
        System.out.println("CatFactory constructor");
    }

    public Cat get() {
        return new Cat();
    }
}
