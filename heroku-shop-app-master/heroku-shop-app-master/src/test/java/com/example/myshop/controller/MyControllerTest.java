package com.example.myshop.controller;

import com.example.myshop.dao.GoodsDao;
import com.example.myshop.dao.UserDao;
import com.example.myshop.model.Goods;
import com.example.myshop.model.Order;
import com.example.myshop.model.User;
import com.example.myshop.service.GoodsService;
import com.example.myshop.service.OrderService;
import com.example.myshop.service.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MyControllerTest {


    @Mock
    GoodsService goodsService;

    @Mock
    UserService userService;

    @Mock
    OrderService orderService;

    @Spy
    @InjectMocks
    MyController myController;

    @Test
    void hello() {
        final Model model = new ExtendedModelMap();
        String result = myController.hello(model);
        assertEquals(result, "index");
    }

    @Test
    void findAllGoods() {
        Goods goods1 = new Goods();
        goods1.setId(1L);
        goods1.setName("a");
        goods1.setPrice(1);
        Goods goods2 = new Goods();
        goods2.setId(2L);
        goods2.setName("b");
        goods2.setPrice(2);
        Goods goods3 = new Goods();
        goods3.setId(3L);
        goods3.setName("c");
        goods3.setPrice(3);
        List<Goods> testList = new ArrayList();
        testList.add(goods1);
        testList.add(goods2);
        testList.add(goods3);
        Mockito.when(goodsService.findAllGoods()).thenReturn(testList);
        final Model model = new ExtendedModelMap();
        String result = myController.findAllGoods(model);
        assertEquals(result, "goods-list");
    }

    @Test
    void createGoodsForm() {
        final Goods testGoods = new Goods();
        testGoods.setId(1L);
        testGoods.setName("a");
        testGoods.setPrice(1);
        String result = myController.createGoodsForm(testGoods);
        assertEquals(result, "goods-create");
    }

    @Test
    void createGoods() {
        final Goods goods = new Goods();
        goods.setId(1L);
        goods.setName("a");
        goods.setPrice(1);
        String result = myController.createGoods(goods);
        assertEquals(result, "redirect:/goods");
    }

    @Test
    void deleteGoods() {
        String result = myController.deleteGoods(1L);
        assertEquals(result, "redirect:/goods");
    }

    @Test
    void updateGoodsForm() {
        final Model model = new ExtendedModelMap();
        String result = myController.updateGoodsForm(1L, model);
        assertEquals(result, "goods-update");
    }


    @Test
    void updateGoods() {
        final Goods goods = new Goods();
        goods.setId(1L);
        goods.setName("a");
        goods.setPrice(1);
        String result = myController.updateGoods(goods);
        assertEquals(result, "redirect:/goods");
    }

    @Test
    void findAllOrders() {
        Order order1 = new Order();
        Goods goods1 = new Goods();
        goods1.setId(1L);
        goods1.setName("a");
        goods1.setPrice(1);
        User user1 = new User();
        user1.setId(1L);
        user1.setFirstName("a");
        user1.setLastName("b");
        order1.setId(1L);
        order1.setGoods(goods1);
        order1.setUser(user1);
        order1.setDate("05.05.2020");
        order1.setQuantity(1);
        Order order2 = new Order();
        Goods goods2 = new Goods();
        goods2.setId(2L);
        goods2.setName("ff");
        goods2.setPrice(2);
        User user2 = new User();
        user2.setId(2L);
        user2.setFirstName("tt");
        user2.setLastName("mm");
        order2.setId(2L);
        order2.setGoods(goods2);
        order2.setUser(user2);
        order2.setDate("06.06.2020");
        order2.setQuantity(2);
        Order order3 = new Order();
        Goods goods3 = new Goods();
        goods3.setId(3L);
        goods3.setName("ggg");
        goods3.setPrice(3);
        User user3 = new User();
        user3.setId(3L);
        user3.setFirstName("xx");
        user3.setLastName("yyy");
        order3.setId(3L);
        order3.setGoods(goods3);
        order3.setUser(user3);
        order3.setDate("07.07.2020");
        order3.setQuantity(3);
        List<Order> testList = new ArrayList();
        testList.add(order1);
        testList.add(order2);
        testList.add(order3);
        Mockito.when(orderService.findAllOrders()).thenReturn(testList);
        final Model model = new ExtendedModelMap();
        String result = myController.findAllOrders(model);
        assertEquals(result, "order-list");
    }

    @Test
    void createOrderForm() {
        Order order1 = new Order();
        Goods goods1 = new Goods();
        goods1.setId(1L);
        goods1.setName("a");
        goods1.setPrice(1);
        User user1 = new User();
        user1.setId(1L);
        user1.setFirstName("a");
        user1.setLastName("b");
        order1.setId(1L);
        order1.setGoods(goods1);
        order1.setUser(user1);
        order1.setDate("05.05.2020");
        order1.setQuantity(1);
        String result = myController.createOrderForm(order1);
        assertEquals(result, "order-create");
    }

    @Test
    void createOrder() {
        Order order1 = new Order();
        Goods goods1 = new Goods();
        goods1.setId(1L);
        goods1.setName("a");
        goods1.setPrice(1);
        User user1 = new User();
        user1.setId(1L);
        user1.setFirstName("a");
        user1.setLastName("b");
        order1.setId(1L);
        order1.setGoods(goods1);
        order1.setUser(user1);
        order1.setDate("05.05.2020");
        order1.setQuantity(1);
        String result = myController.createOrder(order1);
        assertEquals(result, "redirect:/orders");
    }

    @Test
    void deleteOrder() {
        String result = myController.deleteOrder(1L);
        assertEquals(result, "redirect:/orders");
    }

    @Test
    void updateOrderForm() {
        Order order1 = new Order();
        Goods goods1 = new Goods();
        goods1.setId(1L);
        goods1.setName("a");
        goods1.setPrice(1);
        User user1 = new User();
        user1.setId(1L);
        user1.setFirstName("a");
        user1.setLastName("b");
        order1.setId(1L);
        order1.setGoods(goods1);
        order1.setUser(user1);
        order1.setDate("05.05.2020");
        order1.setQuantity(1);
        String result = myController.createOrderForm(order1);
        assertEquals(result, "order-create");
    }

    @Test
    void updateOrder() {
        Order order1 = new Order();
        Goods goods1 = new Goods();
        goods1.setId(1L);
        goods1.setName("a");
        goods1.setPrice(1);
        User user1 = new User();
        user1.setId(1L);
        user1.setFirstName("a");
        user1.setLastName("b");
        order1.setId(1L);
        order1.setGoods(goods1);
        order1.setUser(user1);
        order1.setDate("05.05.2020");
        order1.setQuantity(1);
        String result = myController.updateOrder(order1);
        assertEquals(result, "redirect:/orders");
    }

    @Test
    void findAll() {
        User user1 = new User();
        user1.setId(1L);
        user1.setFirstName("a");
        user1.setLastName("b");
        User user2 = new User();
        user2.setId(2L);
        user2.setFirstName("c");
        user2.setLastName("d");
        User user3 = new User();
        user3.setId(3L);
        user3.setFirstName("e");
        user3.setLastName("f");
        List<User> testList = new ArrayList();
        Mockito.when(userService.findAll()).thenReturn(testList);
        final Model model = new ExtendedModelMap();
        String result = myController.findAll(model);
        assertEquals(result, "user-list");
    }

    @Test
    void createUserForm() {
        final User user1 = new User();
        user1.setId(1L);
        user1.setFirstName("a");
        user1.setLastName("b");
        String result = myController.createUserForm(user1);
        assertEquals(result, "user-create");
    }

    @Test
    void createUser() {
        final User user = new User();
        user.setId(1L);
        user.setFirstName("a");
        user.setLastName("b");
        String result = myController.createUser(user);
        assertEquals(result, "redirect:/users");
    }

    @Test
    void deleteUser() {
        String result = myController.deleteUser(1L);
        assertEquals(result, "redirect:/users");
    }

    @Test
    void updateUserForm() {
        final Model model = new ExtendedModelMap();
        String result = myController.updateUserForm(1L, model);
        assertEquals(result, "user-update");
    }

    @Test
    void updateUser() {
        final User user = new User();
        user.setId(1L);
        user.setFirstName("a");
        user.setLastName("b");
        String result = myController.updateUser(user);
        assertEquals(result, "redirect:/users");
    }
}