package com.icbc.sd.annotationtest.bean;

import com.icbc.sd.annotationtest.annotation.MyComponent;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;

@MyComponent("vip")
@ToString
public class Vip {
    @Value("111t")
    private String name;
}
