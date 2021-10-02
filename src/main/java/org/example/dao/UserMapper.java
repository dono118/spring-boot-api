package org.example.dao;

import org.example.po.User;

public interface UserMapper {

    // 根据用户名查询用户信息
    public User queryUserByName(String username);

    // 根据用户id查询用户信息
    public User queryUserById(Integer id);

    // 添加用户
    public int addUser(User user);

    // 修改用户
    public int updateUser(User user);
}
