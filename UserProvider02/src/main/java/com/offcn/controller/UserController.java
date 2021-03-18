package com.offcn.controller;

import com.offcn.pojo.User;
import com.offcn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;
    @PostMapping("/")
    public String add(@RequestBody User user){
        try {
            userService.add(user);
            return "add-success";
        } catch (Exception e) {
            e.printStackTrace();
            return "add-fail";
        }
    }

    //查询全部数据
    @GetMapping("/")
    public Map findAll(){
        List<User> list = userService.findAll();
        Map map=new HashMap();
        map.put("list",list);
        //添加一个版本说明
        map.put("version","UserProvider002");
        //让响应随机等待一段时间
        int sleepTime = new Random().nextInt(1200);
        try {
            System.out.println("服务2等待时间:"+sleepTime);
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return map;
    }

    //查询指定编号用户详情
    @GetMapping("/{id}")
    public User findOne(@PathVariable("id") Long id){
        return userService.findOne(id);
    }

    //修改
    @PutMapping("/{id}")
    public String update(@PathVariable Long id,@RequestBody User user){
        try {
            user.setId(id);
            userService.update(user);
            return "update-success";
        } catch (Exception e) {
            e.printStackTrace();
            return "update-fail";
        }
    }

    //删除
    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long id){
        try {
            userService.delete(id);
            return "delte-success";
        } catch (Exception e) {
            e.printStackTrace();
            return "delete-fail";
        }
    }
}
