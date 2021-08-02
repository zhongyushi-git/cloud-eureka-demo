package com.zys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/test")
public class TestController {

    @Value("${server.port}")
    private String port;

    @GetMapping("/get")
    public String get() {
        return "我是服务提供者，端口：" + port;
    }

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/discovery")
    public Object discovery() {
        //获取注册的服务列表信息
        List<String> services = discoveryClient.getServices();
        //根据服务名称获取实例列表信息
        String serviceId = "CLOUD-EUREKA-DEMO-PROVIDER";
        List<ServiceInstance> instances = discoveryClient.getInstances(serviceId);

        Map<String, Object> map = new HashMap<>();
        map.put("服务列表", services);
        map.put("实例列表", instances);
        return map;
    }
}
