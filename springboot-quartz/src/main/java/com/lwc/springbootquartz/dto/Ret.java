package com.lwc.springbootquartz.dto;

import lombok.Data;

/**
 * @Author: liwencai
 * @Date: 2022/9/9 14:39
 * @Description:
 */
@Data
public class Ret<T> {

    private Integer code;
    private String msg;
    private T data;
    private boolean success;

    public Ret() {

    }

    public Ret(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
        this.success = Rets.SUCCESS.equals(code);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("{");
        builder.append("'code':").append(code).append(",");
        builder.append("'msg':").append(msg).append(",");
        builder.append("'success':").append(success).append(",");
        builder.append("}");
        return builder.toString();
    }
}
