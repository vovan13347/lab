package com.example.myshop.dao;

import com.example.myshop.model.Order;
import com.example.myshop.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class OrderDao {

    public Order findById(Long id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Order order = session.get(Order.class, id);
        session.close();
        return order;
    }

    public void save(Order order) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(order);
        tx1.commit();
        session.close();
    }

    public void update(Order order) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(order);
        tx1.commit();
        session.close();
    }

    public void delete(Order order) {

        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(order);
        tx1.commit();
        session.close();

    }

    public List<Order> findAll() {
        List<Order> orders =
                (List<Order>)  HibernateSessionFactoryUtil
                        .getSessionFactory()
                        .openSession()
                        .createQuery("From Order")
                        .list();
        return orders;
    }
}
