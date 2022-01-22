package com.example.demo.powermock.mockstatic.service;

import com.example.demo.easypoi.po.User;
import com.example.demo.powermock.mockstatic.dao.UserDao;

public class UserService {

    public int queryUserCount() {
        return UserDao.getCount();
    }

    public void saveUser(User user) {
        UserDao.insertUser(user);
    }
}
