package com.itmuch.cloud.config;

import feign.Contract;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Configuration1 {
    @Bean
    public Contract feignContract(){
        return new feign.Contract.Default();
    }
}
