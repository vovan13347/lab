package com.example.myshop.service;

import com.example.myshop.dao.OrderDao;
import com.example.myshop.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private OrderDao ordersDao;

    @Autowired
    public OrderService(OrderDao ordersDao) {
        this.ordersDao = ordersDao;
    }

    public Order findById(Long id) {
        return ordersDao.getOne(id);
    }

    public void saveOrder(Order order) {
        ordersDao.save(order);
    }

    public void deleteById(Long id) {
        ordersDao.delete(findById(id));
    }

    public void updateOrder(Order order) {
        ordersDao.save(order);
    }

    public List<Order> findAllOrders() {
        return ordersDao.findAll();
    }

}
