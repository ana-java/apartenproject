package com.offcn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer //允许当前应用作为一个EurekaServer
public class EurekaServer01Starter {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServer01Starter.class,args);
    }
}
