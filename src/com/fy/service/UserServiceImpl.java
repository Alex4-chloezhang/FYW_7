package com.fy.service;

import com.fy.dao.UserDaoImpl;
import com.fy.model.User;

public class UserServiceImpl implements UserService {
    UserDaoImpl udi = new UserDaoImpl();

    @Override
    public User getUser(String username, String password) {

        return udi.getUser(username, password);
    }
}
