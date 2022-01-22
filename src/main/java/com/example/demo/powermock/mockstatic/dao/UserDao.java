package com.example.demo.powermock.mockstatic.dao;

import com.example.demo.easypoi.po.User;

public class UserDao {
    public static int getCount() {
        throw new UnsupportedOperationException();
    }

    public static void insertUser(User user) {
        throw new UnsupportedOperationException();
    }
}
