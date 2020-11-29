package com.example.myshop.service;

import com.example.myshop.dao.OrderDao;
import com.example.myshop.model.Goods;
import com.example.myshop.model.Order;
import com.example.myshop.model.User;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;

@SpringBootTest
class OrderServiceTest {

    @Mock
    OrderDao orderDao;

    @Spy
    @InjectMocks
    OrderService orderService;


    @Test
    void findById() {
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
        Mockito.when(orderDao.getOne(1L)).thenReturn(order1);
        Order anotherTestOrder = orderService.findById(1L);
        assertEquals(order1, anotherTestOrder);
    }

    @Test
    void saveOrder() {
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
        orderService.saveOrder(order1);
        Mockito.verify(orderDao, times(1)).save(order1);
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
        Mockito.when(orderDao.getOne(1L)).thenReturn(order1);
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
        orderService.updateOrder(order2);
        Mockito.verify(orderDao, times(1)).save(order2);
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
        Mockito.when(orderDao.findAll()).thenReturn(testList);
        List<Order> result = orderService.findAllOrders();
        assertEquals(result, testList);
    }
}