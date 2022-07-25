package com.lwc.springbootjedis.Test;

import redis.clients.jedis.Jedis;

public class Redis_Set {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("127.0.0.1",6379);
        System.out.println(jedis.ping());
        jedis.flushDB();
        System.out.println("============向集合中添加元素============");
        System.out.println(jedis.sadd("set", "e1", "e2", "e4", "e3", "e0", "e8", "e7", "e5"));
        System.out.println(jedis.sadd("set", "e6"));
        System.out.println(jedis.sadd("set", "e6"));
        System.out.println("set的所有元素为：" + jedis.smembers("set"));
        System.out.println("删除一个元素e0：" + jedis.srem("set", "e0"));
        System.out.println("set的所有元素为：" + jedis.smembers("set"));
        System.out.println("删除两个元素e7和e6：" + jedis.srem("set", "e7", "e6"));
        System.out.println("set的所有元素为：" + jedis.smembers("set"));
        System.out.println("随机的移除集合中的一个元素：" + jedis.spop("set"));
        System.out.println("随机的移除集合中的一个元素：" + jedis.spop("set"));
        System.out.println("set的所有元素为：" + jedis.smembers("set"));
        System.out.println("set中包含元素的个数：" + jedis.scard("set"));
        System.out.println("e3是否在set中：" + jedis.sismember("set", "e3"));
        System.out.println("e1是否在set中：" + jedis.sismember("set", "e1"));
        System.out.println("e1是否在set中：" + jedis.sismember("set", "e5"));
        System.out.println("=================================");
        System.out.println(jedis.sadd("set1", "e1", "e2", "e4", "e3", "e0", "e8", "e7", "e5"));
        System.out.println(jedis.sadd("set2", "e1", "e2", "e4", "e3", "e0", "e8"));
        System.out.println("将set1中删除e1并存入set3中：" + jedis.smove("set1", "set3", "e1"));
        System.out.println("将set1中删除e2并存入set3中：" + jedis.smove("set1", "set3", "e2"));
        System.out.println("set1中的元素：" + jedis.smembers("set1"));
        System.out.println("set3中的元素：" + jedis.smembers("set3"));
        System.out.println("============集合运算=================");
        System.out.println("set1中的元素：" + jedis.smembers("set1"));
        System.out.println("set2中的元素：" + jedis.smembers("set2"));
        System.out.println("set1和set2的交集：" + jedis.sinter("set1", "set2"));
        System.out.println("set1和set2的并集：" + jedis.sunion("set1", "set2"));
        System.out.println("set1和set2的差集：" + jedis.sdiff("set1", "set2")); //set1中有，set2中没有
    }
}
