package com.zys.cloud.dao;

import com.zys.cloud.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserDao {
    int create(User user);

    User getById(@Param("id") Long id);
}
