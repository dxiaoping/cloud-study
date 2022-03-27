package com.example.user.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Slf4j
@RestController
@RequestMapping("redis/ops")
public class RedisController {

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    @PostMapping("string")
    public void stringRedis(){
        redisTemplate.opsForValue().set("xiaoping","candy");
    }
    @PostMapping("key_value")
    public void keyValue(@RequestParam("key") String key,@RequestParam("value") String value){
        if ("".equals(value)){
            value = null;
        }
        redisTemplate.opsForValue().set(key,value);
    }

    @PostMapping("hash")
    public Map<Object, Object> hashRedis(){
        redisTemplate.opsForHash().put("HASH_LOVE","name","candy");
        redisTemplate.opsForHash().put("HASH_LOVE","birthday","1999-11-10");
        return redisTemplate.opsForHash().entries("HASH_LOVE");
    }

    @PostMapping("list")
    public void listRedis(){
        redisTemplate.opsForList().leftPush("list_test","candy");
        redisTemplate.opsForList().leftPush("list_test","xiaoping");
    }

    @PostMapping("set")
    public void setRedis(){
        redisTemplate.opsForSet().add("SET_TEST","xiaoping","candy");
    }

}
