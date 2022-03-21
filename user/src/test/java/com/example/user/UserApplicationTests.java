package com.example.user;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class UserApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    @Test
    public void set(){
//        redisTemplate.opsForValue().set("myKey","myValue");
        long num = 100000;
        for (int i = 1;i<10000;i++){
            num+=i;
            redisTemplate.opsForValue().set("candy_"+num,"唐棠_"+num);
        }

//        redisTemplate.opsForHash().("myKey","myValue");
        System.out.println(redisTemplate.opsForValue().get("sunday"));
    }

}
