package org.example.service;

import org.apache.commons.lang3.StringUtils;
import org.example.dao.UserMapper;
import org.example.po.User;
import org.example.util.AssertUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService {

    @Resource
    private UserMapper userMapper;

    /**
     * 根据用户名查询用户信息
     *
     * @param username 用户名
     * @return 返回用户对象
     */
    public User queryUserByName(String username) {
        return userMapper.queryUserByName(username);
    }

    /**
     * 根据用户id查询用户信息
     *
     * @param id 用户id
     * @return 返回用户对象
     */
    public User queryUserById(Integer id) {
        return userMapper.queryUserById(id);
    }

    /**
     * 添加用户
     *
     * @param user
     * @return
     */
    public void addUser(User user) {
        // 判断用户名和密码是否为空
        AssertUtil.isTrue(StringUtils.isBlank(user.getUsername()), "用户名不能为空");
        AssertUtil.isTrue(StringUtils.isBlank(user.getPassword()), "密码不能为空");
        // 通过用户名查询用户对象
        User temp = userMapper.queryUserByName(user.getUsername());
        // 判断用户名是否已存在
        AssertUtil.isTrue(temp != null, "用户名已存在！");

        // 执行添加操作，判断受影响的行数
        AssertUtil.isTrue(userMapper.addUser(user) < 1, "添加用户失败！");
    }

    /**
     * 修改用户
     *
     * @param user
     * @return
     */
    public void updateUser(User user) {
        // 判断用户Id
        AssertUtil.isTrue(user.getId() == null, "用户数据异常！");

        // 判断用户名和密码是否为空
        AssertUtil.isTrue(StringUtils.isBlank(user.getUsername()), "用户名不能为空");
        AssertUtil.isTrue(StringUtils.isBlank(user.getPassword()), "密码不能为空");
        // 通过用户名查询用户对象
        User temp = userMapper.queryUserByName(user.getUsername());
        // 判断用户名是否已存在(非自己）
        AssertUtil.isTrue(temp != null && !user.getId().equals(temp.getId()), "用户名已存在！");

        // 执行添加操作，判断受影响的行数
        AssertUtil.isTrue(userMapper.updateUser(user) < 1, "修改用户失败！");
    }
}
