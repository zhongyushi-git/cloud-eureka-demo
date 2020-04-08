package com.zys.cloud.controller;

import com.zys.cloud.entity.User;
import com.zys.cloud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private DiscoveryClient discoveryClient;

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

    @GetMapping("/discovery")
    public Object discovery(){
        //获取注册的服务列表信息
        List<String> services = discoveryClient.getServices();
        //根据服务名称获取实例列表信息
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-EUREKA-DEMO-PROVIDER");

        Map<String,Object> map=new HashMap<>();
        map.put("服务列表",services);
        map.put("实例列表",instances);
        return map;
    }
}
