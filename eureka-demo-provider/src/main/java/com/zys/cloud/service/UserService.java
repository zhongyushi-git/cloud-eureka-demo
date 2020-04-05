package com.zys.cloud.service;

import com.zys.cloud.entity.User;

public interface UserService {
    public User getUser(long id);

    int addUser(User user);
}
