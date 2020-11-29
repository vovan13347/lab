package com.example.myshop.service;

import com.example.myshop.model.User;
import com.example.myshop.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserDao usersDao;

    @Autowired
    public UserService(UserDao usersDao) {
        this.usersDao = usersDao;
    }

    public User findById(Long id) {
        return usersDao.getOne(id);
    }

    public void saveUser(User user) {
        usersDao.save(user);
    }

    public void deleteById(Long id) {
        usersDao.delete(findById(id));
    }

    public void updateUser(User user) {
        usersDao.save(user);
    }

    public List<User> findAll() {
        return usersDao.findAll();
    }

}