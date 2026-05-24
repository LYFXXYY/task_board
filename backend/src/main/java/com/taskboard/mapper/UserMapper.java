package com.taskboard.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.taskboard.entity.User;
import org.apache.ibatis.annotations.Mapper;

// 继承 BaseMapper<User> 后，自动拥有 insert, select, update, delete 方法
@Mapper
public interface UserMapper extends BaseMapper<User> {
    // 这里暂时不需要写任何代码，MyBatis-Plus 已经帮我们实现了基础方法
}