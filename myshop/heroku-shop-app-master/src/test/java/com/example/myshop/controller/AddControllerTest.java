package com.example.myshop.controller;

import com.example.myshop.model.Goods;
import com.example.myshop.model.User;
import com.example.myshop.service.GoodsService;
import com.example.myshop.service.OrderService;
import com.example.myshop.service.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class AddControllerTest {

    @Mock
    GoodsService goodsService;

    @Mock
    UserService userService;

    @Mock
    OrderService orderService;

    @Spy
    @InjectMocks
    AddController addController;

    @Test
    void findAllUsers() {
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
        List<User> result = addController.findAllUsers();
        assertEquals(result, testList);
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
        List<Goods> result = addController.findAllGoods();
        assertEquals(result, testList);
    }

    @Test
    void findUserById() {
        User testUser = new User();
        testUser.setId(1L);
        testUser.setFirstName("Ivan");
        testUser.setLastName("Ivanoff");
        Mockito.when(userService.findById(1L)).thenReturn(testUser);
        User anotherTestUser = userService.findById(1L);
        assertEquals("Ivan", anotherTestUser.getFirstName());
        assertEquals("Ivanoff", anotherTestUser.getLastName());
    }

    @Test
    void findGoodsById() {
        Goods testGoods = new Goods();
        testGoods.setId(1L);
        testGoods.setName("Laptop Asus");
        testGoods.setPrice(100000);
        Mockito.when(goodsService.findById(1L)).thenReturn(testGoods);
        Goods anotherTestGoods = goodsService.findById(1L);
        assertEquals("Laptop Asus", anotherTestGoods.getName());
        assertEquals(100000, anotherTestGoods.getPrice());
    }

}