package com.example.myshop.service;

import com.example.myshop.model.Goods;
import com.example.myshop.dao.GoodsDao;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsService {

    private GoodsDao goodsDao = new GoodsDao();

    public GoodsService() {
    }

    public Goods findById(Long id) {
        return goodsDao.findById(id);
    }

    public void saveGoods(Goods goods) {
        goodsDao.save(goods);
    }

    public void deleteById(Long id) {
        goodsDao.delete(findById(id));
    }

    public void updateGoods(Goods goods) {
        goodsDao.update(goods);
    }

    public List<Goods> findAllGoods() {
        return goodsDao.findAll();
    }

}

