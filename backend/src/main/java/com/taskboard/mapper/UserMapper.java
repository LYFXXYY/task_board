package com.taskboard.mapper;

import com.taskboard.entity.User;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper // 告诉 Spring 这是一个数据库操作接口
public interface UserMapper {
    // 查询所有用户
    List<User> selectAll();
}