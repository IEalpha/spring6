package com.icbc.sd.factory;

import com.icbc.sd.bean.Animal;
import com.icbc.sd.bean.Cat;
import com.icbc.sd.bean.Cow;
import com.icbc.sd.bean.Dog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AnimalFactory {

    private static final Logger logger = LoggerFactory.getLogger(AnimalFactory.class);
    public static Animal createAnimal(String type) {
        return switch (type.toUpperCase()) {
            case "CAT" -> new Cat();
            case "DOG" -> new Dog();
            case "COW" -> new Cow();
            default -> {
                logger.error("不支持该动物的创建: {}", type);
                throw new IllegalArgumentException("Invalid type");
            }
        };
    }
}
