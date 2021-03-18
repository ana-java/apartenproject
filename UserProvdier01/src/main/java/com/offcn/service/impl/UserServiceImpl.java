package com.offcn.service.impl;

import com.offcn.dao.UserDao;
import com.offcn.pojo.User;
import com.offcn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;
    @Override
    public void add(User user) {
        userDao.save(user);
    }

    @Override
    public void delete(Long id) {
userDao.deleteById(id);
    }

    @Override
    public void update(User user) {
   userDao.saveAndFlush(user);
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public User findOne(Long id) {
        Optional<User> optional = userDao.findById(id);
        //判断是否查询到了数据
        if(optional.isPresent()){
            return optional.get();
        }else {
            return null;
        }
    }
}
