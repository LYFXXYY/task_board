package com.taskboard.controller;

import com.taskboard.common.Result;
import com.taskboard.entity.Task;
import com.taskboard.mapper.TaskMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/task")
public class TaskController {

    @Autowired
    private TaskMapper taskMapper;

    @PostMapping("/create")
    public Result<Task> create(@RequestBody Task task) {
        task.setStatus(0);
        task.setCreateTime(LocalDateTime.now());
        taskMapper.insert(task);
        return Result.success(task);
    }

    @GetMapping("/list")
    public Result<List<Task>> list() {
        List<Task> tasks = taskMapper.selectAll();
        return Result.success(tasks);
    }

    @PutMapping("/status/{taskId}")
    public Result<String> updateStatus(@PathVariable Integer taskId, @RequestParam Integer status) {
        taskMapper.updateStatus(taskId, status);
        return Result.success("状态更新成功");
    }
}
