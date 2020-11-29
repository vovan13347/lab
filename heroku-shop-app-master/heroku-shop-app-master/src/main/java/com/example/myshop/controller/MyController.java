package com.example.myshop.controller;


import com.example.myshop.model.Goods;
import com.example.myshop.model.User;
import com.example.myshop.utils.HostValueGetter;
import com.example.myshop.model.Order;
import com.example.myshop.service.GoodsService;
import com.example.myshop.service.OrderService;
import com.example.myshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;




@Controller
public class MyController {

    @Value("${server.port}")
    private int serverPort;

    private String ip = InetAddress.getLoopbackAddress().getHostAddress();

    private final UserService userService;
    private final GoodsService goodsService;
    private final OrderService orderService;

    @Autowired
    public MyController(UserService userService, GoodsService goodsService, OrderService orderService) {

        this.userService = userService;
        this.goodsService = goodsService;
        this.orderService = orderService;
    }

    @GetMapping("/")
    public String hello(Model model) {
        HostValueGetter hostValueGetter = new HostValueGetter();
        model.addAttribute("localHostName", hostValueGetter.getHostId());
        model.addAttribute("UUID", hostValueGetter.uuid());
        model.addAttribute("ip", ip);
        model.addAttribute("serverPort", serverPort);
        return "index";
    }

    @GetMapping("/goods")
    public String findAllGoods(Model model){
        List<Goods> goods = goodsService.findAllGoods();
        model.addAttribute("goods", goods);
        return "goods-list";
    }

    @GetMapping("/goods-create")
    public String createGoodsForm(Goods goods){
        return "goods-create";
    }

    @PostMapping("/goods-create")
    public String createGoods(Goods goods){
        goodsService.saveGoods(goods);
        return "redirect:/goods";
    }

    @GetMapping("goods-delete/{id}")
    public String deleteGoods(@PathVariable("id") Long id){
        goodsService.deleteById(id);
        return "redirect:/goods";
    }

    @GetMapping("/goods-update/{id}")
    public String updateGoodsForm(@PathVariable("id") Long id, Model model){
        Goods goods = goodsService.findById(id);
        model.addAttribute("goods", goods);
        return "goods-update";
    }

    @PostMapping("/goods-update")
    public String updateGoods(Goods goods){
        goodsService.updateGoods(goods);
        return "redirect:/goods";
    }

    @GetMapping("/orders")
    public String findAllOrders(Model model){
        List<Order> orders = orderService.findAllOrders();
        model.addAttribute("orders", orders);
        return "order-list";
    }

    @GetMapping("/order-create")
    public String createOrderForm(Order order){
        return "order-create";
    }

    @PostMapping("/order-create")
    public String createOrder(Order order){
        orderService.saveOrder(order);
        return "redirect:/orders";
    }

    @GetMapping("order-delete/{id}")
    public String deleteOrder(@PathVariable("id") Long id){
        orderService.deleteById(id);
        return "redirect:/orders";
    }

    @GetMapping("/order-update/{id}")
    public String updateOrderForm(@PathVariable("id") Long id, Model model){
        Order order = orderService.findById(id);
        model.addAttribute("order", order);
        return "order-update";
    }

    @PostMapping("/order-update")
    public String updateOrder(Order order){
        orderService.updateOrder(order);
        return "redirect:/orders";
    }

    @GetMapping("/users")
    public String findAll(Model model){
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "user-list";
    }

    @GetMapping("/user-create")
    public String createUserForm(User user){
        return "user-create";
    }

    @PostMapping("/user-create")
    public String createUser(User user){
        userService.saveUser(user);
        return "redirect:/users";
    }

    @GetMapping("user-delete/{id}")
    public String deleteUser(@PathVariable("id") Long id){
        userService.deleteById(id);
        return "redirect:/users";
    }

    @GetMapping("/user-update/{id}")
    public String updateUserForm(@PathVariable("id") Long id, Model model){
        User user = userService.findById(id);
        model.addAttribute("user", user);
        return "user-update";
    }

    @PostMapping("/user-update")
    public String updateUser(User user){
        userService.updateUser(user);
        return "redirect:/users";
    }

}
