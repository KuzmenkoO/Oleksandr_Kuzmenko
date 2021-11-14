package com.epam.spring.homework2.beans;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class BeanE implements Bean{
    private String name;
    private int value;

    @PostConstruct
    public void postConstruct(){
        System.out.println(getClass().getSimpleName() + " inside @PostConstruct");
    }
    @PreDestroy
    public void preDestroy(){
        System.out.println(getClass().getSimpleName() + " inside @PreDestroy");
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
        return "BeanE{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }
}