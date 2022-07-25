package com.lwc.springbootdruid.dao;

import com.lwc.springbootdruid.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Auther: liwencai
 * @Date: 2022/7/25 10:09
 * @Description:
 */
@Repository
public interface UserDao {
    List<User> selectAll();
}
