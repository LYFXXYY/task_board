package com.taskboard.controller;

import com.taskboard.common.Result;
import com.taskboard.entity.User;
import com.taskboard.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired // 自动注入我们之前写好的 UserMapper
    private UserMapper userMapper;

    @GetMapping("/list")
    public Result<List<User>> list() {
        // 真正调用 Mapper 去数据库查询所有用户
        List<User> users = userMapper.selectAll();
        // 用统一格式返回
        return Result.success(users);
    }
}