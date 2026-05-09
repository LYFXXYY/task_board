package com.taskboard.controller;

import com.taskboard.common.Result;
import com.taskboard.common.Result;
import com.taskboard.entity.User;
import com.taskboard.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController // 标记这是一个返回 JSON 数据的控制器
@RequestMapping("/api/user") // 统一的路由前缀
public class UserController {

    @Autowired // 自动注入刚才写的 UserMapper
    private UserMapper userMapper;

    // 映射 GET 请求：http://localhost:8080/api/user/list
    @GetMapping("/list")
    public Result<List<User>> list() {
        List<User> users = userMapper.selectAll();
        return Result.success(users); // 用我们封装好的 Result 返回
    }
}