package org.example.controller;

import org.example.po.User;
import org.example.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class UserController {

    @Resource
    private UserService userService;

    /**
     * 根据用户名查询用户信息
     * @param username 用户名
     * @return 返回用户对象
     */
    @GetMapping("user/name/{username}")
    public User queryUserByName(@PathVariable String username) {
        return userService.queryUserByName(username);
    }

    /**
     * 根据用户id查询用户信息
     * @param id 用户id
     * @return 返回用户对象
     */
    @GetMapping("user/{id}")
    public User queryUserById(@PathVariable Integer id) {
        return userService.queryUserById(id);
    }
}
