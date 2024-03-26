package com.icbc.sd.singletonAndSetModelCircularDependency;

import lombok.ToString;

public class Wife {
    private String name;
    private Husband husband;

    public Wife() {
        System.out.println("Wife's constructor");
    }

    public void setName(String name) {
        System.out.println("Wife's setName");
        this.name = name;
    }

    public void setHusband(Husband husband) {
        System.out.println("Wife's setHusband");
        this.husband = husband;
    }
}
