package com.offcn.controller;

import com.offcn.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private HelloService helloService;
    @RequestMapping("demo1")
    public String demo1(){
        return helloService.sayHello();
    }
}
