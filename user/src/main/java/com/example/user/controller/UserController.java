package com.example.user.controller;

import com.example.user.feign.GoodsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("user")
@Slf4j
public class UserController {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    GoodsService goodsService;

    @PostMapping("firstUser")
    public Object firstUser(){
//        String url = "http://cloud-goods/goods/listGoods";
//        Object result = restTemplate.getForObject(url,String.class);
        Object result = goodsService.listGoods();


        return result;
    }

    @LoadBalanced
    @Autowired
    DiscoveryClient discoveryClient;

    @PostMapping("listServiceInstance")
    public List<ServiceInstance> listServiceInstance(@RequestParam("serviceName") String serviceName){
        List<ServiceInstance> serviceList = discoveryClient.getInstances(serviceName);

        return serviceList;
    }
}
