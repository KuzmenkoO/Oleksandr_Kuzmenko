package com.epam.spring.homework2.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class BeanD implements Bean {
    @Value("${beanD.name}")
    private String name;
    @Value("${beanD.value}")
    private int value;

    public void myInitMethod() {
        System.out.println(getClass().getSimpleName() + " inside initMethod");
    }

    public void myDestroyMethod() {
        System.out.println(getClass().getSimpleName() + " inside destroyMethod");
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "BeanD{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }
}