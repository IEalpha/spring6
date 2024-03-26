package com.icbc.sd.myspringtest.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Vip {
    private String name;
    private Integer age;
    private boolean isMale;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public boolean getIsMale() {
        return isMale;
    }

    public void setIsMale(boolean male) {
        isMale = male;
    }
}
