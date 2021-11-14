package com.epam.spring.homework2.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class BeanB implements Bean {
    @Value("${beanB.name}")
    private String name;
    @Value("${beanB.value}")
    private int value;

    public void myInitMethod() {
        System.out.println(getClass().getSimpleName() + " inside initMethod");
    }

    public void myOtherInitMethod() {
        System.out.println(getClass().getSimpleName() + " inside myOtherInitMethod");
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
        return "BeanB{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }
}