package org.example.service;

import org.example.dao.UserMapper;
import org.example.po.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService {

    @Resource
    private UserMapper userMapper;

    /**
     * 根据用户名查询用户信息
     * @param username 用户名
     * @return 返回用户对象
     */
    public User queryUserByName(String username) {
        return userMapper.queryUserByName(username);
    }
}
