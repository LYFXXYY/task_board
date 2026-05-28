package com.taskboard.common;

import lombok.Data;

@Data
public class Result<T> {

    private Integer code;   // 状态码
    private String message; // 描述信息
    private T data;         // 泛型数据（T代表任意对象，比如 User 对象，或者 List<User>）

    // 构造方法私有化，只允许通过下面的静态方法创建实例
    private Result() {
    }

    // 私有化构造方法并初始化值
    private Result(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    // --- 静态工厂方法 ---

    // 成功，有数据
    public static <T> Result<T> success(T data) {
        return new Result<>(200, "操作成功", data);
    }

    // 成功，无数据
    public static <T> Result<T> success() {
        return new Result<>(200, "操作成功", null);
    }

    // 失败
    public static <T> Result<T> error(String message) {
        return new Result<>(500, message, null);
    }
}