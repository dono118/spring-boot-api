package org.example.dao;

import org.example.po.User;

public interface UserMapper {

    // 根据用户名查询用户信息
    public User queryUserByName(String username);
}
