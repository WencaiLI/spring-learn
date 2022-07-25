package com.lwc.springbootjedis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * @Auther: liwencai
 * @Date: 2022/7/25 14:05
 * @Description:
 */
@RestController
@RequestMapping("jedis")
public class RedisController {
    @Autowired
    JedisPool jedisPool;

    @RequestMapping(value = "/set",method = RequestMethod.GET)
    public Object set(){
        Jedis jedis = jedisPool.getResource();
        jedis.set("jedis","jedis");
        return "1";
    }

    @RequestMapping(value = "/get",method = RequestMethod.GET)
    public Object get(){
        Jedis jedis = jedisPool.getResource();
        return jedis.get("jedis");
    }
}
