package com.example.user.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "cloud-goods", path = "goods")
public interface GoodsService {
    @GetMapping("listGoods")
    String listGoods();

}
