package com.taskboard.mapper;

import com.taskboard.entity.Task;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

@Mapper
public interface TaskMapper {

    List<Task> selectAll();

    void insert(Task task);

    int updateStatus(@Param("id") Integer id, @Param("status") Integer status);
}