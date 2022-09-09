package com.lwc.springbootquartz.runner;


import com.lwc.springbootquartz.db.generated.entity.QuartzJob;
import com.lwc.springbootquartz.service.JobService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author: liwencai
 * @Description: 启动定时任务
 * @Date: 2022/9/9
 */
@Component
public class StartJob implements ApplicationRunner {

    @Autowired
    private JobService jobService;

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {
        log.info("start Job >>>>>>>>>>>>>>>>>>>>>>>");
        List<QuartzJob> list = jobService.getTaskList();
        for (QuartzJob quartzJob : list) {
            jobService.addJob(quartzJob);
        }
    }
}
