package com.lwc.springbootjedis.Test;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.SortingParams;

public class Redis_Sort {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("127.0.0.1",6379);
        System.out.println(jedis.ping());
        jedis.flushDB();
        jedis.lpush("list", "zhangsan", "lisi", "wanger", "mazi", "qianwu", "zhaoliu");
        System.out.println("list的内容：" + jedis.lrange("list", 0, -1));
        SortingParams sortingParameters = new SortingParams();
        System.out.println(jedis.sort("list", sortingParameters.alpha()));
        System.out.println("===============================");
        jedis.lpush("sortedList", "13", "26", "12", "0", "7", "24");
        System.out.println("sortedList排序前：" + jedis.lrange("sortedList", 0, -1));
        System.out.println("升序：" + jedis.sort("sortedList", sortingParameters.asc()));
        System.out.println("升序：" + jedis.sort("sortedList", sortingParameters.desc()));
        System.out.println("===============================");
        jedis.lpush("ids", "33");
        jedis.lpush("ids", "44");
        jedis.lpush("ids", "11");
        jedis.hset("user：55", "score", "55");
        jedis.hset("user：55", "name", "lisi");
        jedis.hset("user：44", "score", "66");
        jedis.hset("user：44", "name", "zhangsan");
        jedis.hset("user：33", "score", "33");
        jedis.hset("user：33", "name", "wanger");
        jedis.hset("user：22", "score", "79");
        jedis.hset("user：22", "name", "mazi");
        jedis.hset("user：11", "score", "24");
        jedis.hset("user：11", "name", "qianwu");
        sortingParameters = new SortingParams();
        sortingParameters.get("user：*->name");
        sortingParameters.get("user：*->score");
        System.out.println(jedis.sort("ids", sortingParameters));
    }

}
