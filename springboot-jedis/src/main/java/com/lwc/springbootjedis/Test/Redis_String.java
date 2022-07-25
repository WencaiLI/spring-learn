package com.lwc.springbootjedis.Test;

import redis.clients.jedis.Jedis;

import java.util.concurrent.TimeUnit;

public class Redis_String {
    public static void main(String[] args) throws InterruptedException {
        Jedis jedis = new Jedis("127.0.0.1",6379);
        System.out.println(jedis.ping());
        jedis.flushDB();
        System.out.println("===========增加数据===========");
        System.out.println(jedis.set("key1", "value1"));
        System.out.println(jedis.set("key2", "value2"));
        System.out.println(jedis.set("key3", "value3"));
        System.out.println("删除键key2：" + jedis.del("key2"));
        System.out.println("获取键key2：" + jedis.get("key2"));
        System.out.println("修改key1：" + jedis.set("key1", "value1Changed"));
        System.out.println("获取key1的值：" + jedis.get("key1"));
        System.out.println("在key3后面加入值：" + jedis.append("key3", "End"));
        System.out.println("key3的值：" + jedis.get("key3"));
        System.out.println("增加多个键值对：" + jedis.mset("key4", "value4", "key5", "value5", "key6", "value6"));
        System.out.println("获取多个键值对：" + jedis.mget("key4", "key5", "key6"));
        System.out.println("删除多个键值对：" + jedis.del("key4", "key5"));
        System.out.println("获取多个键值对：" + jedis.mget("key4", "key5", "key6"));

        jedis.flushDB();
        System.out.println("===========新增键值对防止覆盖原先值==============");
        System.out.println(jedis.setnx("key11", "value1"));
        System.out.println(jedis.setnx("key22", "value2"));
        System.out.println(jedis.setnx("key22", "value2-new"));
        System.out.println(jedis.get("key11"));
        System.out.println(jedis.get("key22"));

        System.out.println("===========新增键值对并设置有效时间=============");
        System.out.println(jedis.setex("key3", 4, "value3"));
        System.out.println(jedis.get("key3"));
        TimeUnit.SECONDS.sleep(3);
        System.out.println(jedis.get("key3"));

        System.out.println("===========获取原值，更新为新值==========");
        System.out.println(jedis.getSet("key2", "key2GetSet"));
        System.out.println(jedis.get("key2"));

        System.out.println("获得key2的值的字串：" + jedis.getrange("key2", 2, 4));
    }
}
