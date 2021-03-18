package com.offcn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
public class UserWeb01Starter {
    public static void main(String[] args) {
        SpringApplication.run(UserWeb01Starter.class,args);
    }

    //创建RestTemplate 调用远程rest接口
    @Bean
    public RestTemplate createRestTemplate(){
        return new RestTemplate();
    }
}
