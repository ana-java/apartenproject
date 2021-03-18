package com.offcn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient //允许把当前服务注册到EurekaServer
public class HelloProvider01Starter {
    public static void main(String[] args) {
        SpringApplication.run(HelloProvider01Starter.class,args);
    }
}
