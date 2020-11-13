package com.example.myshop.service;

import com.example.myshop.dao.OrderDao;
import com.example.myshop.model.Order;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private OrderDao ordersDao = new OrderDao();

    public OrderService() {
    }

    public Order findById(Long id) {
        return ordersDao.findById(id);
    }

    public void saveOrder(Order order) {
        ordersDao.save(order);
    }

    public void deleteById(Long id) {
        ordersDao.delete(findById(id));
    }

    public void updateOrder(Order order) {
        ordersDao.update(order);
    }

    public List<Order> findAllOrders() {
        return ordersDao.findAll();
    }

}
