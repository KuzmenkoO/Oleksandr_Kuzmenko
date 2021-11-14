package com.epam.spring.homework2.config;

import com.epam.spring.homework2.beans.*;
import org.springframework.context.annotation.*;
import org.springframework.context.annotation.Bean;

@Configuration
@PropertySource("application.properties")
@ComponentScan("com.epam.spring.homework2.beans")
public class SecondConfig {

    @Bean(initMethod = "myInitMethod", destroyMethod = "myDestroyMethod")
    @DependsOn("beanD")
    public BeanB beanB() {
        return new BeanB();
    }

    @Bean(initMethod = "myInitMethod", destroyMethod = "myDestroyMethod")
    @DependsOn("beanB")
    public BeanC beanC() {
        return new BeanC();
    }

    @Bean(initMethod = "myInitMethod", destroyMethod = "myDestroyMethod")
    public BeanD beanD() {
        return new BeanD();
    }

    @Bean
    @Lazy
    public BeanF beanF() {
        return new BeanF();
    }

    @Bean
    public MyBeanPostProcessor myBeanPostProcessor(){
        return new MyBeanPostProcessor();
    }

    @Bean
    public MyBeanFactoryPostProcessor myBeanFactoryPostProcessor(){
        return new MyBeanFactoryPostProcessor();
    }
}