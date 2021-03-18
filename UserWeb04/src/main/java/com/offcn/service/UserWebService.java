package com.offcn.service;

import com.offcn.config.feignConfig;
import com.offcn.pojo.User;
import com.offcn.service.impl.UserWebServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
@FeignClient(value = "USERPROVIDER",configuration = feignConfig.class,fallback = UserWebServiceImpl.class)
public interface UserWebService {

    @PostMapping("/user/")
    public void add(User user);
    @DeleteMapping("/user/{id}")
    public void delete(@PathVariable("id") Long id);

    @PutMapping("/user/{id}")
    public void update(@PathVariable Long id,User user);

    @GetMapping("/user/")
    public Map findAll();
    @GetMapping("/user/{id}")
    public User findOne(@PathVariable("id") Long id);
}
