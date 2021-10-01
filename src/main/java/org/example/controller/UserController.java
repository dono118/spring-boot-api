package org.example.controller;

import org.example.exception.ParamsException;
import org.example.po.User;
import org.example.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {

    @Resource
    private UserService userService;

    /**
     * 根据用户名查询用户信息
     *
     * @param username 用户名
     * @return 返回用户对象
     */
    @GetMapping("user/name/{username}")
    public User queryUserByName(@PathVariable String username) {
        return userService.queryUserByName(username);
    }

    /**
     * 根据用户id查询用户信息
     *
     * @param id 用户id
     * @return 返回用户对象
     */
    @GetMapping("user/{id}")
    public User queryUserById(@PathVariable Integer id) {
        return userService.queryUserById(id);
    }

    /**
     * 添加用户
     *
     * @param user
     * @return
     */
    @PostMapping("user")
    public Map<String, Object> addUser(@RequestBody User user) {
        Map<String, Object> map = new HashMap<>();
        try {
            userService.addUser(user);
            map.put("code", "0000");
            map.put("msg", "添加用户成功！");
        } catch (ParamsException p) {
            map.put("code", p.getCode());
            map.put("msg", p.getMsg());
            p.printStackTrace();
        } catch (Exception e) {
            map.put("code", "2001");
            map.put("msg", "添加用户失败！");
            e.printStackTrace();
        }
        return map;
    }
}
