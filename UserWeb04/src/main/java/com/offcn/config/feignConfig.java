package com.offcn.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class feignConfig {

    @Bean
    public Logger.Level createLevel(){
        return Logger.Level.FULL;
    }
}
