package com.example.demo.powermock.mockstatic.service;

import com.example.demo.easypoi.po.User;
import com.example.demo.powermock.mockstatic.dao.UserDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(PowerMockRunner.class)
@PrepareForTest({UserService.class, UserDao.class})
public class UserServiceTest {

    @Test
    public void queryUserCountTest() throws Exception {
        PowerMockito.mockStatic(UserDao.class);
        PowerMockito.when(UserDao.getCount()).thenReturn(10);
        UserService userService = new UserService();
        int userCount = userService.queryUserCount();
        assertEquals(10, userCount);
    }

    @Test
    public void saveUserTest() throws Exception {
        PowerMockito.mockStatic(UserService.class);
        PowerMockito.doNothing().when(UserDao.class);
        UserService userService = new UserService();
        User user = new User();
        userService.saveUser(user);
        PowerMockito.verifyStatic(UserService.class);
    }
}