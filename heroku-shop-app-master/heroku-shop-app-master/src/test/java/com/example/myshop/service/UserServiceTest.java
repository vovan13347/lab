package com.example.myshop.service;

import com.example.myshop.dao.UserDao;
import com.example.myshop.model.User;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.ArrayList;
import java.util.List;
import static org.mockito.Mockito.times;
import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
class UserServiceTest {

    @Mock
    UserDao userDao;

    @Spy
    @InjectMocks
    UserService userService;


    @Test
    void findById() {
        User testUser = new User();
        testUser.setId(1L);
        testUser.setFirstName("Ivan");
        testUser.setLastName("Ivanoff");
        Mockito.when(userDao.getOne(1L)).thenReturn(testUser);
        User anotherTestUser = userService.findById(1L);
        assertEquals("Ivan", anotherTestUser.getFirstName());
        assertEquals("Ivanoff", anotherTestUser.getLastName());
    }

    @Test
    void saveUser() {
        User testUser = new User();
        testUser.setId(1L);
        testUser.setFirstName("Ivan");
        testUser.setLastName("Ivanoff");
        userService.saveUser(testUser);
        Mockito.verify(userDao, times(1)).save(testUser);
    }


    @Test
    void updateUser() {
        User testUser = new User();
        testUser.setId(1L);
        testUser.setFirstName("Ivan");
        testUser.setLastName("Ivanoff");
        Mockito.when(userDao.getOne(1L)).thenReturn(testUser);
        User AnotherTestUser = new User();
        AnotherTestUser.setId(2L);
        AnotherTestUser.setFirstName("Petr");
        AnotherTestUser.setLastName("Petroff");
        userService.updateUser(AnotherTestUser);
        Mockito.verify(userDao, times(1)).save(AnotherTestUser);
    }

    @Test
    void findAll() {
        User user1 = new User();
        user1.setId(1L);
        user1.setFirstName("a");
        user1.setLastName("b");
        User user2 = new User();
        user2.setId(2L);
        user2.setFirstName("c");
        user2.setLastName("d");
        User user3 = new User();
        user3.setId(3L);
        user3.setFirstName("e");
        user3.setLastName("f");
        List<User> testList = new ArrayList();
        testList.add(user1);
        testList.add(user2);
        testList.add(user3);
        Mockito.when(userDao.findAll()).thenReturn(testList);
        List<User> result = userService.findAll();
        assertEquals(result, testList);
    }
}