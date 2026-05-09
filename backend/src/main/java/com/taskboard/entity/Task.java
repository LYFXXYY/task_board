package com.taskboard.entity;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class Task {
    private Integer id;
    private String title;
    private String content;
    private Integer status; // 0待办 1进行中 2已完成
    private Integer assigneeId; // 负责人ID
    private LocalDateTime createTime;
}