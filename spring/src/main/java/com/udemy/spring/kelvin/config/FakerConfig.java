package com.udemy.spring.kelvin.config;

import com.github.javafaker.Faker;
import com.udemy.spring.kelvin.annotation.LazyConfiguration;
import org.springframework.context.annotation.Bean;

@LazyConfiguration
public class FakerConfig {

    @Bean
    public Faker getFaker(){
        return new Faker();
    }
}
