package com.offcn.service;

import com.offcn.pojo.User;

import java.util.List;

public interface UserService {

    public void add(User user);
    public void delete(Long id);

    public void update(User user);

    public List<User> findAll();
    public User findOne(Long id);
}
