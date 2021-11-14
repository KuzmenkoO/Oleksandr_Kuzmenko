package com.epam.spring.homework2;

import com.epam.spring.homework2.config.FirstConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(FirstConfig.class);
        System.out.println("____________________________________________________");
        String[] contextName = context.getBeanDefinitionNames();
        for (String name : contextName) {
            System.out.println(context.getBean(name));
        }
    }
}