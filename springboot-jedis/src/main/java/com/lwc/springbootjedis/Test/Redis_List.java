package com.lwc.springbootjedis.Test;

import redis.clients.jedis.Jedis;

public class Redis_List {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("127.0.0.1",6379);
        System.out.println(jedis.ping());
        jedis.flushDB();
        System.out.println("===========添加一个list===========");
        jedis.lpush("list", "zhangsan", "lisi", "wanger", "mazi", "qianwu", "zhaoliu");
        jedis.lpush("list", "zhangsan");
        jedis.lpush("list", "mazi");
        System.out.println("list的内容：" + jedis.lrange("list", 0, -1));//-1代表倒数第一个元素，-2代表倒数第二个元素
        System.out.println("list区间0-3的元素：" + jedis.lrange("list", 0, 3));
        System.out.println("===============================");
        // 删除列表指定的值 ，第二个参数为删除的个数（有重复时），后add进去的值先被删，类似于出栈
        System.out.println("删除指定元素个数：" + jedis.lrem("list", 2, "zhangsan"));
        System.out.println("list的内容：" + jedis.lrange("list", 0, -1));
        System.out.println("删除下表0-3区间之外的元素：" + jedis.ltrim("list", 0, 3));
        System.out.println("list的内容：" + jedis.lrange("list", 0, -1));
        System.out.println("list列表出栈（左端）：" + jedis.lpop("list"));
        System.out.println("list的内容：" + jedis.lrange("list", 0, -1));
        System.out.println("list添加元素，从列表右端，与lpush相对应：" + jedis.rpush("list", "qianwu"));
        System.out.println("list的内容：" + jedis.lrange("list", 0, -1));
        System.out.println("list列表出栈（右端）：" + jedis.rpop("list"));
        System.out.println("list的内容：" + jedis.lrange("list", 0, -1));
        System.out.println("修改list指定下标1的内容：" + jedis.lset("list", 1, "mazi"));
        System.out.println("list的内容：" + jedis.lrange("list", 0, -1));
        System.out.println("===============================");
        System.out.println("list的长度：" + jedis.llen("list"));
        System.out.println("获取list下标为2的元素：" + jedis.lindex("list", 2));
        System.out.println("===============================");
        jedis.lpush("list2", "3", "6", "2", "0", "7", "4");
        System.out.println("list2排序前：" + jedis.lrange("list2", 0, -1));
        System.out.println(jedis.sort("sortedList"));
        System.out.println("list2排序后：" + jedis.lrange("list2", 0, -1));
    }
}
