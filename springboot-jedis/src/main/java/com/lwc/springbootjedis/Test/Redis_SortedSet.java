package com.lwc.springbootjedis.Test;

import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Map;

public class Redis_SortedSet {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("127.0.0.1",6379);
        System.out.println(jedis.ping());
        jedis.flushDB();
        Map<String, Double> map = new HashMap<String, Double>();
        map.put("key1", 1.2);
        map.put("key2", 4.5);
        map.put("key3", 5.2);
        map.put("key4", 3.2);
        System.out.println(jedis.zadd("zset", 2.5, "key5"));
        System.out.println(jedis.zadd("zset", map));
        System.out.println("zset中的所有元素：" + jedis.zrange("zset", 0, -1));
        System.out.println("zset中的所有元素：" + jedis.zrangeWithScores("zset", 0, -1));
        System.out.println("zset中的所有元素：" + jedis.zrangeByScore("zset", 0, 10));
        System.out.println("zset中的所有元素：" + jedis.zrangeByScoreWithScores("zset", 0, 10));
        System.out.println("zset中key2的分值：" + jedis.zscore("zset", "key2"));
        System.out.println("zset中key2的排名：" + jedis.zrank("zset", "key2"));
        System.out.println("删除zset中的元素key3：" + jedis.zrem("zset", "key3"));
        System.out.println("zset中的所有元素：" + jedis.zrange("zset", 0, -1));
        System.out.println("zset中元素的个数：" + jedis.zcard("zset"));
        System.out.println("zset中分值在1-4之间的元素的个数：" + jedis.zcount("zset", 1, 4));
        System.out.println("key2的分值加上5：" + jedis.zincrby("zset", 5, "key2"));
        System.out.println("key3的分值加上4：" + jedis.zincrby("zset", 4, "key3"));
        System.out.println("zset中的所有元素：" + jedis.zrange("zset", 0, -1));
    }
}
