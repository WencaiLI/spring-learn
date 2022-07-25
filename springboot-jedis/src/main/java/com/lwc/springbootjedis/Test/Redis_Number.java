package com.lwc.springbootjedis.Test;

import redis.clients.jedis.Jedis;

public class Redis_Number {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("127.0.0.1",6379);
        System.out.println(jedis.ping());
        jedis.flushDB();
        jedis.set("key1", "1");
        jedis.set("key2", "2");
        jedis.set("key3", "2.3");
        System.out.println("key1的值：" + jedis.get("key1"));
        System.out.println("key2的值：" + jedis.get("key2"));
        System.out.println("key1的值加1：" + jedis.incr("key1"));
        System.out.println("获取key1的值：" + jedis.get("key1"));
        System.out.println("key2的值减1：" + jedis.decr("key2"));
        System.out.println("获取key2的值：" + jedis.get("key2"));
        System.out.println("将key1的值加上整数5：" + jedis.incrBy("key1", 5));
        System.out.println("获取key1的值：" + jedis.get("key1"));
        System.out.println("将key2的值减去整数5：" + jedis.decrBy("key2", 5));
        System.out.println("获取key2的值：" + jedis.get("key2"));
        System.out.println(jedis.incrByFloat("key3", 3.5));
    }
}
