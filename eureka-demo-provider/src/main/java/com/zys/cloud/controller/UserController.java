package com.zys.cloud.controller;

import com.zys.cloud.entity.User;
import com.zys.cloud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/get/{id}")
    public User getUser(@PathVariable("id")long id){
        return userService.getUser(id);
    }

    @PostMapping("/add")
    public Map<String,Object> addUser(@RequestBody User user){
        System.out.println(user);
        Map<String,Object> map=new HashMap<>();
        if(userService.addUser(user)!=0){
            map.put("msg","添加成功");
            map.put("code",200);
        }else{
            map.put("msg","添加失败");
            map.put("code",444);
        }
        return map;
    }
}
