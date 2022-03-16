package com.example.goods.service.impl;

import com.example.goods.service.GoodsService;
import org.springframework.stereotype.Service;

@Service
public class GoodsServiceImpl implements GoodsService {
    @Override
    public String firstGoods() {
        return "firstGoods";
    }

    @Override
    public String listGoods() {
        return "listGoods";
    }
}
