package com.epam.spring.homework2.beans;

import org.springframework.stereotype.Component;

@Component
public class BeanE implements Bean{
    private String name;
    private int value;

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
        return "BeanE{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }
}