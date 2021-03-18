package com.offcn.controller;

import com.offcn.pojo.User;
import com.offcn.service.UserWebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Controller
public class UserController {

    @Autowired
    private UserWebService userWebService;

    //显示全部用户列表
    @RequestMapping("/")
    public String list(Model model){
        Map map = userWebService.findAll();
        model.addAttribute("page",map.get("list"));
        model.addAttribute("version",map.get("version"));
        return "user/list";
    }

    //跳转到新增页面
    @RequestMapping("/toAdd")
    public String toAdd(){
        return "user/userAdd";
    }

    //保存新增方法
    @RequestMapping("/add")
    public String save(User user){
        userWebService.add(user);
        return "redirect:/";
    }

    //跳转到修改页面
    @RequestMapping("/toEdit/{id}")
    public String toEdit(@PathVariable("id") Long id, Model model){
        User user = userWebService.findOne(id);
        model.addAttribute("user",user);
        return "user/userEdit";
    }

    //保存修改数据
    @RequestMapping("/update")
    public String update(User user){
        userWebService.update(user);
        return "redirect:/";
    }

    //删除
    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id){
        userWebService.delete(id);
        return "redirect:/";
    }
}
