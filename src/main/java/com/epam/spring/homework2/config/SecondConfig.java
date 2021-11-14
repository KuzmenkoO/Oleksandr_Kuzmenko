package com.epam.spring.homework2.config;

import com.epam.spring.homework2.beans.BeanB;
import com.epam.spring.homework2.beans.BeanC;
import com.epam.spring.homework2.beans.BeanD;
import com.epam.spring.homework2.beans.BeanF;
import org.springframework.context.annotation.*;

@Configuration
@PropertySource("application.properties")
@ComponentScan("com.epam.spring.homework2.beans")
public class SecondConfig {

    @Bean
    @DependsOn("beanD")
    public BeanB beanB() {
        return new BeanB();
    }

    @Bean
    @DependsOn("beanB")
    public BeanC beanC() {
        return new BeanC();
    }

    @Bean
    public BeanD beanD() {
        return new BeanD();
    }

    @Bean
    @Lazy
    public BeanF beanF() {
        return new BeanF();
    }
}