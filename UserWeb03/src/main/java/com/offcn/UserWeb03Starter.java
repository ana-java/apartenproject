package com.offcn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
@EnableCircuitBreaker //开启熔断
public class UserWeb03Starter {
    public static void main(String[] args) {
        SpringApplication.run(UserWeb03Starter.class,args);
    }

    //创建RestTemplate 调用远程rest接口
    @Bean
    @LoadBalanced  //使用Ribbon负载均衡进行服务查找
    public RestTemplate createRestTemplate(){
        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
        //设置链接超时时间
        factory.setConnectTimeout(250);
        //设置读超时时间
        factory.setReadTimeout(250);
        return new RestTemplate(factory);
    }
}
