package com.lwc.springbootquartz.dto;

/**
 * @Author: liwencai
 * @Date: 2022/9/9 14:38
 * @Description:
 */
public class Rets {

    public static final Integer SUCCESS = 20000;
    public static final Integer FAILURE = 9999;
    public static  final Integer TOKEN_EXPIRE=50014;

    public static Ret success(Object data) {
        return new Ret(Rets.SUCCESS, "成功", data);
    }

    public static Ret failure(String msg) {
        return new Ret(Rets.FAILURE, msg, null);
    }

    public static Ret success() {
        return new Ret(Rets.SUCCESS, "成功", null);
    }
    public static  Ret expire(){
        return new Ret(Rets.TOKEN_EXPIRE,"token 过期",null);
    }
}
