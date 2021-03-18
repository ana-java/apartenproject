package com.offcn.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.offcn.pojo.User;
import com.offcn.service.UserWebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserWebServiceImpl implements UserWebService {

   /* @Autowired
    private DiscoveryClient discoveryClient;*/

   //支持负载均衡服务查找客户端工具类
    /*@Autowired
    private LoadBalancerClient loadBalancerClient;*/

    @Autowired
    private RestTemplate restTemplate;

    //获取指定服务的地址和端口号
    private String getServiceUrlport(){

        return "http://USERPROVIDER";
    }
    @Override
    public void add(User user) {
       //获取服务地址
        String url = getServiceUrlport();
        ResponseEntity<String> responseEntity = restTemplate.postForEntity(url + "/user/", user, String.class);
        System.out.println("返回状态码:"+responseEntity.getStatusCodeValue()+"新增操作服务返回内容"+responseEntity.getBody());
    }

    @Override
    public void delete(Long id) {
        String url = getServiceUrlport();
        restTemplate.delete(url+"/user/"+id);
        System.out.println("删除接口调用成功");
    }

    @Override
    public void update(User user) {
        String url = getServiceUrlport();
        restTemplate.put(url+"/user/"+user.getId(),user);
        System.out.println("更新接口调用成功");
    }

    @Override
    @HystrixCommand(fallbackMethod = "findAllCallBack")
    public Map findAll() {
        String url = getServiceUrlport();
        ResponseEntity<Map> responseEntity = restTemplate.getForEntity(url + "/user/", Map.class);
        Map map = responseEntity.getBody();
        System.out.println("查询全部接口调用:状态码:"+responseEntity.getStatusCodeValue()+" 返回值:"+map.get("list"));
        return map;
    }
     //熔断超时后，回调方法
    public Map findAllCallBack(){
        Map map=new HashMap();
        map.put("list",new ArrayList());
        map.put("version","调用远程用户服务接口超时，触发了回调");
        return map;
    }

    @Override
    public User findOne(Long id) {
        String url = getServiceUrlport();
        User user = restTemplate.getForObject(url + "/user/" + id, User.class);
        System.out.println("调用查询指定编号用户数据接口:"+user.toString());
        return user;
    }
}
