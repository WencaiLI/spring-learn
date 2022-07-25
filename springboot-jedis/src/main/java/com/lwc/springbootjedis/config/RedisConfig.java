package com.lwc.springbootjedis.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @Auther: liwencai
 * @Date: 2022/7/25 14:02
 * @Description:
 */
@Configuration
public class RedisConfig {

    @Autowired
    RedisConfigProperties redisConfigProperties;

    @Bean
    public JedisPool JedisPoolFactory() {
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxIdle(redisConfigProperties.getPoolMaxIdle());
        poolConfig.setMaxTotal(redisConfigProperties.getPoolMaxTotal());
        poolConfig.setMaxWaitMillis(redisConfigProperties.getPoolMaxWait() * 1000);
        JedisPool jp = new JedisPool(poolConfig, redisConfigProperties.getHost(), redisConfigProperties.getPort(),
                redisConfigProperties.getTimeout()*1000, redisConfigProperties.getPassword(), 0);
        return jp;
    }
}
