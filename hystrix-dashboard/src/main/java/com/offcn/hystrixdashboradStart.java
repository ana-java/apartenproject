package com.offcn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard //允许当前应用作为熔断监控中心服务器使用
public class hystrixdashboradStart {
    public static void main(String[] args) {
        SpringApplication.run(hystrixdashboradStart.class,args);
    }
}
