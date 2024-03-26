package com.icbc.sd.simpleBeanFactoryInstantiation;


public class StarFactory {

    public StarFactory() {
        System.out.println("StarFactory constructor");
    }

    public static Star createStar() {
        return new Star();
    }
}
