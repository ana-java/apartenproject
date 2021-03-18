package com.offcn.service.impl;

import com.offcn.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
@Service
public class HelloServiceImpl implements HelloService {

    @Autowired //客户端发现组件，就可以使用它取EurekaServer查找服务
    private DiscoveryClient discoveryClient;


    @Autowired //rest风格接口调用工具类
    private RestTemplate restTemplate;

    //定义一个方法查找对应服务
    private String findRemotServer(){
        List<ServiceInstance> serviceInstanceList = discoveryClient.getInstances("HELLOPROVIDER");
        //判断集合是否为空
        if(serviceInstanceList!=null&&serviceInstanceList.size()>0){
            //提取第一个服务
            ServiceInstance serviceInstance = serviceInstanceList.get(0);
            //获取服务地址
            String host = serviceInstance.getHost();
            //获取服务端口号
            int port = serviceInstance.getPort();
            //拼接服务协议头和地址端口
            return "http://"+host+":"+port;
        }

        return null;
    }
    @Override
    public String sayHello() {
        //获取服务地址和端口
        String url = findRemotServer();
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(url+"/hello", String.class);
        String body = responseEntity.getBody();
        System.out.println("远程服务返回信息:"+body);
        return body;
    }
}
