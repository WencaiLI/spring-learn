package com.lwc.springbootjedis.Test;

import redis.clients.jedis.Jedis;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Redis_Common {
    public static void main(String[] args) throws InterruptedException {
        Jedis jedis = new Jedis("127.0.0.1",6379);
        System.out.println(jedis.ping());
        System.out.println("清空数据：" + jedis.flushDB());
        System.out.println("判断某个键是否存在：" + jedis.exists("username"));
        System.out.println("新增的键值对：" + jedis.set("username", "zhangsan"));
        System.out.println("是否存在：" + jedis.exists("name"));
        System.out.println("新增的键值对：" + jedis.set("password", "1234"));
        Set<String> keys = jedis.keys("*");
        System.out.println("系统中所有的键如下：" + keys);
        System.out.println("删除键password：" + jedis.del("password"));
        System.out.println("判断键password是否存在：" + jedis.exists("password"));
        System.out.println("设置键username的过期时间为6s：" + jedis.expire("username", 6));
        TimeUnit.SECONDS.sleep(2);
        System.out.println("查看键username的剩余生存时间：" + jedis.ttl("username"));
        System.out.println("移除键username的生存时间：" + jedis.persist("username"));
        System.out.println("查看键username的剩余生存时间：" + jedis.ttl("username"));
        System.out.println("查看键username所存储的值的类型：" + jedis.type("username"));
    }
}
