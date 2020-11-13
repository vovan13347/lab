package com.example.myshop.dao;

import com.example.myshop.model.Goods;
import com.example.myshop.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class GoodsDao {

    public Goods findById(long id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Goods goods = session.get(Goods.class, id);
        session.close();
        return goods;
    }

    public void save(Goods goods) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(goods);
        tx1.commit();
        session.close();
    }

    public void update(Goods goods) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(goods);
        tx1.commit();
        session.close();
    }

    public void delete(Goods goods) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(goods);
        tx1.commit();
        session.close();
    }

    public List<Goods> findAll() {
        List<Goods> goods =
                (List<Goods>)  HibernateSessionFactoryUtil
                        .getSessionFactory()
                        .openSession()
                        .createQuery("From Goods")
                        .list();
        return goods;
    }
}
