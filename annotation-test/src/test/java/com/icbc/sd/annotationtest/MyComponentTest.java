package com.icbc.sd.annotationtest;

import com.icbc.sd.annotationtest.annotation.MyComponent;
import com.icbc.sd.annotationtest.utils.ClassUtil;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class MyComponentTest {

    @Test
    void testMyComponent() {
        Map<String, Object> beanMap = new HashMap<>();
        String packageName = "com.icbc.sd.annotationtest.bean";
        //扫描包下的所有类
        List<Class<?>> classes = ClassUtil.getClasses(packageName);
        System.out.println("classes: " + classes + "\n============================================");

        classes.forEach(clazz -> {
            if (clazz.isAnnotationPresent(MyComponent.class)) {
                MyComponent annotation = clazz.getAnnotation(MyComponent.class);
                String beanName = annotation.value();
                try {
                    Object bean = clazz.getDeclaredConstructor().newInstance();
                    beanMap.put(beanName, bean);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        beanMap.forEach((k, v) -> System.out.println("k: " + k + ", v: " + v));
    }
}
