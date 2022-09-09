package com.lwc.springbootquartz.job;

import com.lwc.springbootquartz.config.JobExecuter;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @Author: liwencai
 * @Date: 2022/9/9 15:35
 * @Description:
 */
@Component
public class TestJob extends JobExecuter {
    @Override
    public void execute(Map<String, Object> dataMap) throws Exception {
        System.out.println("测试");
    }
}
