package com.lwc.springbootjedis.Test;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

public class Redis_Tranascation {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("127.0.0.1",6379);
        Transaction multi = jedis.multi();
        multi.set("liwencai", "1807070202");
        multi.set("chenyihao","1807070203");
        multi.set("sucongjie","1807070205");
        multi.exec();
        multi.close();
    }
}
