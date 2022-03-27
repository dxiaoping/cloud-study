package com.example.user.controller;

import com.example.user.feign.GoodsService;
import com.example.user.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("user")
//@RefreshScope
@Slf4j
public class UserController {

    @Autowired
    private RestTemplate restTemplate;
//    @Autowired
//    GoodsService goodsService;

//    @PostMapping("firstUser")
//    public Object firstUser(){
////        String url = "http://cloud-goods/goods/listGoods";
////        Object result = restTemplate.getForObject(url,String.class);
//        Object result = goodsService.listGoods();
//
//
//        return result;
//    }

    @Autowired
    User user;

    @Value("${person.name}")
    String name;

    @PostMapping("getUser")
    public User getUser(){
        log.info("获取配置信息：{}",name);
        log.info("获取配置信息-用户：{}",user);
        return user;
    }

    @Autowired
    DiscoveryClient discoveryClient;

    @PostMapping("listServiceInstance")
    public List<ServiceInstance> listServiceInstance(@RequestParam("serviceName") String serviceName){
        List<ServiceInstance> serviceList = discoveryClient.getInstances(serviceName);

        return serviceList;
    }
}
