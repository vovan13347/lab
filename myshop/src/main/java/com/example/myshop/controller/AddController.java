package com.example.myshop.controller;


import com.example.myshop.model.Goods;
import com.example.myshop.model.Order;
import com.example.myshop.model.User;
import com.example.myshop.service.GoodsService;
import com.example.myshop.service.OrderService;
import com.example.myshop.service.UserService;
import com.example.myshop.utils.HostValueGetter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Slf4j
@RestController
@RequestMapping(value = AddController.URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class AddController {
    public static final String URL = "/api/myshop";

    private final GoodsService goodsService;
    private final UserService userService;
    private final OrderService orderService;

    @Autowired
    public AddController(UserService userService, GoodsService goodsService, OrderService orderService) {
        this.userService = userService;
        this.goodsService = goodsService;
        this.orderService = orderService;
    }

    @GetMapping(value = "/users")
    public List<User> findAllUsers() {
        return userService.findAll();
    }

    @GetMapping(value = "/goods")
    public List<Goods> findAllGoods() {
        return goodsService.findAllGoods();
    }

    @GetMapping(value = "/users/{id}")
    public User findUserById(@PathVariable("id") Long id) {
        return userService.findById(id);
    }

    @GetMapping(value = "/goods/{id}")
    public Goods findGoodsById(@PathVariable("id") Long id) {
        return goodsService.findById(id);
    }

    @GetMapping(value = "hostname")
    public String getHostName() {
        HostValueGetter hostValueGetter = new HostValueGetter();
        return hostValueGetter.getHostId();
    }

}
