package com.lwc.springbootdruid.controller;

import com.lwc.springbootdruid.model.User;
import com.lwc.springbootdruid.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Auther: liwencai
 * @Date: 2022/7/25 10:07
 * @Description:
 */
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    //这里随便给一个借口，请求之后druid就会监控到当前操作的详细信息
    //访问localhost:8080/druid
    @RequestMapping(value = {"", "/", "index"},method = RequestMethod.GET)
    public List<User> list() {
        return userService.list();
    }
}
