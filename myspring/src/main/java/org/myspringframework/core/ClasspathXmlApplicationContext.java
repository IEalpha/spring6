package org.myspringframework.core;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClasspathXmlApplicationContext implements ApplicationContext {

    private Map<String, Object> singletonBeanMap;

    public ClasspathXmlApplicationContext(String path) {
        try {
            singletonBeanMap = new HashMap<>();
            // 1. 读取配置文件
            SAXReader reader = new SAXReader();
            InputStream resourceAsStream = ClassLoader.getSystemClassLoader().getResourceAsStream(path);
            Document document = reader.read(resourceAsStream);
            List<Node> nodes = document.selectNodes("//bean");
            // 2. 解析配置文件，将解析到的BeanDefinition放到beanMap中
            nodes.forEach(node -> {
                try {
                    Element nodeEle = (Element) node;
                    String id = nodeEle.attributeValue("id");
                    String clazz = nodeEle.attributeValue("class");
                    System.out.println("id: " + id + ", class: " + clazz);
                    Object bean = Class.forName(clazz).getDeclaredConstructor().newInstance();
                    singletonBeanMap.put(id, bean);
                    System.out.println("singletonBeanMap: " + singletonBeanMap);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            });
            nodes.forEach(node -> {
                Element nodeEle = (Element) node;
                String id = nodeEle.attributeValue("id");
                Object bean = singletonBeanMap.get(id);
                List<Element> propertyList = nodeEle.elements("property");
                propertyList.forEach(property -> {
                    try {
                        String name = property.attributeValue("name");
                        String ref = property.attributeValue("ref");
                        String value;
                        String setMethodName = "set" + name.substring(0, 1).toUpperCase() + name.substring(1);
                        if (ref != null) {
                            Object propertyBean = singletonBeanMap.get(ref);
                            bean.getClass().getDeclaredMethod(setMethodName, propertyBean.getClass()).invoke(bean, propertyBean);
                        } else {
                            value = property.attributeValue("value");
                            Class fieldClazz = bean.getClass().getDeclaredField(name).getType();
                            // 根据fieldClazz的类型将value转换成对应的类型
                            if (fieldClazz == Integer.class || fieldClazz == int.class) {
                                bean.getClass().getDeclaredMethod(setMethodName, fieldClazz).invoke(bean, Integer.valueOf(value));
                            } else if (fieldClazz == Boolean.class || fieldClazz == boolean.class) {
                                bean.getClass().getDeclaredMethod(setMethodName, fieldClazz).invoke(bean, Boolean.valueOf(value));
                            } else if (fieldClazz == Long.class || fieldClazz == long.class) {
                                bean.getClass().getDeclaredMethod(setMethodName, fieldClazz).invoke(bean, Long.valueOf(value));
                            } else if (fieldClazz == Double.class || fieldClazz == double.class) {
                                bean.getClass().getDeclaredMethod(setMethodName, fieldClazz).invoke(bean, Double.valueOf(value));
                            } else {
                                bean.getClass().getDeclaredMethod(setMethodName, fieldClazz).invoke(bean, value);
                            }
                        }
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                });
            });
            System.out.println(this.singletonBeanMap);

            // 3. 实例化beanMap中的bean
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Object getBean(String beanName) {
        return this.singletonBeanMap.get(beanName);
    }
}
