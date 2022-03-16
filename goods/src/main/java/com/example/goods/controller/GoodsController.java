package com.example.goods.controller;

import com.example.goods.service.GoodsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("goods")
@Slf4j
public class GoodsController {
//    @NacosInjected   // 通过注解注入nacos的NamingService，并提供discovery方法，可以根据服务名称获得注册到Nacos上的服务地址
//    private NamingService namingService;

    @Resource
    GoodsService goodsService;

    @GetMapping("firstGoods")
    public String firstGoods(){
        return goodsService.firstGoods();
    }

    @GetMapping("listGoods")
    public String listGoods(){
        return goodsService.listGoods();
    }
}
