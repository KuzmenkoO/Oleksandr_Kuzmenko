package com.epam.spring.homework2;

import com.epam.spring.homework2.beans.BeanA;
import com.epam.spring.homework2.beans.BeanB;
import com.epam.spring.homework2.beans.BeanC;
import com.epam.spring.homework2.beans.BeanD;
import com.epam.spring.homework2.config.FirstConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(FirstConfig.class);
//        System.out.println(context.getBean(BeanB.class));
//        System.out.println(context.getBean(BeanC.class));
//        System.out.println(context.getBean(BeanD.class));
//        System.out.println(context.getBean(BeanA.class));
        String[] contextName = context.getBeanDefinitionNames();
        for (String name:contextName) {
            System.out.println(name);
            System.out.println(context.getBean(name));
        }
    }
}
