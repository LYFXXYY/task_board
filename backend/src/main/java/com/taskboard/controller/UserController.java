package com.taskboard.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.taskboard.common.Result;
import com.taskboard.entity.User;
import com.taskboard.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

// @RestController = @Controller + @ResponseBody
@RestController
@RequestMapping("/api/user") // 统一前缀
public class UserController {

    // 1. 注册接口 (先写个空壳)
    @Autowired // 注入 Mapper
    private UserMapper userMapper;

    @PostMapping("/register")
    public Result<String> register(@RequestBody User user) {
        // 1. 判重：根据用户名查询数量
        // select count(*) from sys_user where username = ?
        Long count = userMapper.selectCount(
                new QueryWrapper<User>().eq("username", user.getUsername())
        );

        if (count > 0) {
            return Result.error("该账号已存在");
        }

        // 2. 插入数据
        // 注意：文档要求存明文密码，所以直接存
        // 设置创建时间
        user.setCreateTime(new Date());

        // 执行插入
        userMapper.insert(user);

        return Result.success("注册成功");
    }

    // 2. 登录接口
    @PostMapping("/login")
    public Result<User> login(@RequestBody User user) {
        // 1. 根据用户名和密码查询
        // select * from sys_user where username = ? and password = ?
        User dbUser = userMapper.selectOne(
                new QueryWrapper<User>()
                        .eq("username", user.getUsername())
                        .eq("password", user.getPassword())
        );

        // 2. 判断是否查到
        if (dbUser == null) {
            return Result.error("账号或密码错误");
        }

        // 3. 登录成功，返回用户信息 (注意：只返回 id 和 username，不要把密码传给前端)
        // 为了安全，把密码置空
        dbUser.setPassword(null);

        return Result.success(dbUser);
    }

    // 6. 用户列表接口
    @GetMapping("/list")
    public Result list() {
        // 查询所有用户
        List<User> users = userMapper.selectList(null);

        // 把密码脱敏（置空）
        users.forEach(u -> u.setPassword(null));

        return Result.success(users);
    }
}