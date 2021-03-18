package com.offcn.service.impl;

import com.offcn.pojo.User;
import com.offcn.service.UserWebService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
@Component
public class UserWebServiceImpl implements UserWebService {
    @Override
    public void add(User user) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void update(Long id, User user) {

    }

    @Override
    public Map findAll() {
        Map map=new HashMap();
        map.put("list",new ArrayList());
        map.put("version","远程服务调用超时，降级处理");
        return map;
    }

    @Override
    public User findOne(Long id) {
        return null;
    }
}
