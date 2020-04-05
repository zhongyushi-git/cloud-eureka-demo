package com.zys.cloud.controller;

import com.zys.cloud.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@RestController
@RequestMapping("/consumer")
public class UserController {
    private final  String BASE_URL="http://127.0.0.1:8001";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/get/{id}")
    public User getUser(@PathVariable("id") long id){
        return restTemplate.getForObject(BASE_URL+"/user/get/"+id,User.class);
    }

    @PostMapping("/add")
    public Map<String,Object> addUser(User user){
        return restTemplate.postForObject(BASE_URL+"/user/add",user,Map.class);
    }

}
