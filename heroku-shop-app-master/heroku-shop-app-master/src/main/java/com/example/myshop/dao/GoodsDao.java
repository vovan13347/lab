package com.example.myshop.dao;

import com.example.myshop.model.Goods;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GoodsDao extends JpaRepository<Goods, Long> {
}