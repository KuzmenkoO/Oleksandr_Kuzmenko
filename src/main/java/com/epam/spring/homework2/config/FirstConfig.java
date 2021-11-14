package com.epam.spring.homework2.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(SecondConfig.class)
public class FirstConfig {
}
