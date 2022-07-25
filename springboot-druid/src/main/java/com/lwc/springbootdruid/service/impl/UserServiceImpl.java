package com.lwc.springbootdruid.service.impl;

import com.lwc.springbootdruid.dao.UserDao;
import com.lwc.springbootdruid.model.User;
import com.lwc.springbootdruid.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: liwencai
 * @Date: 2022/7/25 10:03
 * @Description:
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;

    @Override
    public List<User> list() {
        return userDao.selectAll();
    }
}
