package com.lwc.springbootjedis.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Auther: liwencai
 * @Date: 2022/7/25 14:01
 * @Description:
 */
@Component
@Data
@ConfigurationProperties(prefix="redis")
public class RedisConfigProperties {
    private String host;
    private int port;
    private int timeout;//秒
    private String password;
    private int poolMaxTotal;
    private int poolMaxIdle;
    private int poolMaxWait;//秒

}
