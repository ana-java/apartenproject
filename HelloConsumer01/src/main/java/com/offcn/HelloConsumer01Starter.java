package com.offcn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class HelloConsumer01Starter {
    public static void main(String[] args) {
        SpringApplication.run(HelloConsumer01Starter.class,args);
    }
    @Bean
    public RestTemplate createrestTempalte(){
      return   new RestTemplate();
    }
}
