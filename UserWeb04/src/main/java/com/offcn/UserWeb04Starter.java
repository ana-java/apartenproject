package com.offcn;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients //开启feign
public class UserWeb04Starter {
    public static void main(String[] args) {
        SpringApplication.run(UserWeb04Starter.class,args);
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

    //把熔断监控访问地址注册到springboot
    @Bean
    public ServletRegistrationBean registerServlet(){
        HystrixMetricsStreamServlet hystrixMetricsStreamServlet = new HystrixMetricsStreamServlet();
        //创建一个servlet的注册器
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(hystrixMetricsStreamServlet);
        //配置servlet的访问顺序
        servletRegistrationBean.setLoadOnStartup(1);
        //设置servlet的访问路径
        servletRegistrationBean.addUrlMappings("/hystrix.stream");
        //设置servlet的名称
        servletRegistrationBean.setName("hystrixMetricsStreamServlet");
        return servletRegistrationBean;
    }
}
