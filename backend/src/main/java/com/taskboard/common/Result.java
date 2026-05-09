package com.taskboard.common;

import lombok.Data;

@Data // Lombok 注解，自动生成 getter/setter
public class Result<T> {
    private Integer code;
    private String message;
    private T data;

    // 成功返回的静态方法
    public static <T> Result<T> success(T data) {
        Result<T> result = new Result<>();
        result.setCode(200);
        result.setMessage("操作成功");
        result.setData(data);
        return result;
    }

    // 失败返回的静态方法
    public static <T> Result<T> error(String message) {
        Result<T> result = new Result<>();
        result.setCode(500);
        result.setMessage(message);
        return result;
    }
}