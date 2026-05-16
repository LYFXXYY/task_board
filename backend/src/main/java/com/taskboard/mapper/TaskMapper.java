package com.taskboard.mapper;

import com.taskboard.entity.Task;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface TaskMapper {
    // 查询所有任务
    List<Task> selectAll();
}