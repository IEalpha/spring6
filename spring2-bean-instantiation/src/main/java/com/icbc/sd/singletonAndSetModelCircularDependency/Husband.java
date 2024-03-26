package com.icbc.sd.singletonAndSetModelCircularDependency;

import lombok.ToString;

public class Husband {

    private String name;
    private Wife wife;

    public Husband() {
        System.out.println("Husband's constructor");
    }

    public void setName(String name) {
        System.out.println("Husband's setName");
        this.name = name;
    }

    public void setWife(Wife wife) {
        System.out.println("Husband's setWife");
        this.wife = wife;
    }


}
