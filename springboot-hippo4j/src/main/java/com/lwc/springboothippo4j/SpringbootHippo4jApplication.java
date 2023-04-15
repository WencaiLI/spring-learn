package com.lwc.springboothippo4j;

import cn.hippo4j.core.enable.EnableDynamicThreadPool;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDynamicThreadPool
public class SpringbootHippo4jApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootHippo4jApplication.class, args);
    }

}
