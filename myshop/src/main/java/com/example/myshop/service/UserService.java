package com.example.myshop.service;

import com.example.myshop.model.User;
import com.example.myshop.dao.UserDao;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserDao usersDao = new UserDao();

    public UserService() {
    }

    public User findById(Long id) {
        return usersDao.findById(id);
    }

    public void saveUser(User user) {
        usersDao.save(user);
    }

    public void deleteById(Long id) {
        usersDao.delete(findById(id));
    }

    public void updateUser(User user) {
        usersDao.update(user);
    }

    public List<User> findAll() {
        return usersDao.findAll();
    }

}