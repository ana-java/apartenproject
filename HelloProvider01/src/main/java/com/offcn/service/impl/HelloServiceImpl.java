package com.offcn.service.impl;

import com.offcn.service.HelloService;
import org.springframework.stereotype.Service;

@Service
public class HelloServiceImpl implements HelloService {
    @Override
    public String sayHello() {
        return "服务提供者被调用，返回信息";
    }
}
