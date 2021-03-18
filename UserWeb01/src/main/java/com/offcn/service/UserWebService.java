package com.offcn.service;

import com.offcn.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserWebService {

    public void add(User user);
    public void delete(Long id);

    public void update(User user);

    public Map findAll();
    public User findOne(Long id);
}
