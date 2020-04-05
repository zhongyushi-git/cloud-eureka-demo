package com.zys.cloud.service.impl;

import com.zys.cloud.dao.UserDao;
import com.zys.cloud.entity.User;
import com.zys.cloud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User getUser(long id) {
        return userDao.getById(id);
    }

    @Override
    public int addUser(User user) {
       return userDao.create(user);
    }
}
