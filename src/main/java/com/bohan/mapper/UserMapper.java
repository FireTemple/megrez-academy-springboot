package com.bohan.mapper;

import com.bohan.entity.User;

import java.util.List;

public interface UserMapper {

    List<User> queryAll();

    List<User> queryUserByUsername(String username);

    int insertSelective(User user);

}
