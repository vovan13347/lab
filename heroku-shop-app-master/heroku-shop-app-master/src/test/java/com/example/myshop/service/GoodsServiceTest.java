package com.example.myshop.service;

import com.example.myshop.dao.GoodsDao;
import com.example.myshop.model.Goods;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;

@SpringBootTest
class GoodsServiceTest {

    @Mock
    GoodsDao goodsDao;

    @Spy
    @InjectMocks
    GoodsService goodsService;


    @Test
    void findById() {
        Goods testGoods = new Goods();
        testGoods.setId(1L);
        testGoods.setName("Laptop Asus");
        testGoods.setPrice(100000);
        Mockito.when(goodsDao.getOne(1L)).thenReturn(testGoods);
        Goods anotherTestGoods = goodsService.findById(1L);
        assertEquals("Laptop Asus", anotherTestGoods.getName());
        assertEquals(100000, anotherTestGoods.getPrice());
    }

    @Test
    void saveGoods() {
        Goods testGoods = new Goods();
        testGoods.setId(1L);
        testGoods.setName("Laptop Asus");
        testGoods.setPrice(100000);
        goodsService.saveGoods(testGoods);
        Mockito.verify(goodsDao, times(1)).save(testGoods);
    }


    @Test
    void updateGoods() {
        Goods testGoods = new Goods();
        testGoods.setId(1L);
        testGoods.setName("Laptop Asus");
        testGoods.setPrice(100000);
        Mockito.when(goodsDao.getOne(1L)).thenReturn(testGoods);
        Goods AnotherTestGoods = new Goods();
        AnotherTestGoods.setId(2L);
        AnotherTestGoods.setName("PC MSI");
        AnotherTestGoods.setPrice(200000);
        goodsService.updateGoods(AnotherTestGoods);
        Mockito.verify(goodsDao, times(1)).save(AnotherTestGoods);
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
        Mockito.when(goodsDao.findAll()).thenReturn(testList);
        List<Goods> result = goodsService.findAllGoods();
        assertEquals(result, testList);
    }
}