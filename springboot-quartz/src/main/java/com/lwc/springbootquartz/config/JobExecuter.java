package com.lwc.springbootquartz.config;

import com.lwc.springbootquartz.db.generated.entity.QuartzJob;
import com.lwc.springbootquartz.db.generated.entity.Task;
import com.lwc.springbootquartz.service.TaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Map;

/**
 * @Author: liwencai
 * @Date: 2022/9/9 15:00
 * @Description:
 */
@Component
public abstract class JobExecuter {

    protected static final Logger log = LoggerFactory.getLogger(JobExecuter.class);

    @Autowired
    private TaskService taskService;

    private QuartzJob job;

    public void setJob(QuartzJob job) {
        this.job = job;
    }

    public void execute() {
        Map<String, Object> dataMap = job.getDataMap();
        String taskId = job.getJobName();
        Task task = taskService.getById(Long.valueOf(taskId));
        final String taskName = task.getName();
        log.info(">>>>>>>>>>>>>>>>>开始执行定时任务[" + taskName + "]<<<<<<<<<<<<<<<<<<<");

        String exeResult = "执行成功";
        final LocalDateTime exeAt = LocalDateTime.now();
        try {
            execute(dataMap);
            task.setExecResult(exeResult);
        } catch (Exception e) {
            task.setExecResult("执行失败");
            log.error("exeucte " + getClass().getName() + " error : ", e);
        }

        task.setExecAt(exeAt);
        taskService.updateById(task);
        log.info(">>>>>>>>>>>>>>>>>执行定时任务[" + taskName + "]结束<<<<<<<<<<<<<<<<<<<");
    }

    /**
     *
     * @param dataMap 数据库配置的参数
     */
    public abstract void execute(Map<String, Object> dataMap) throws Exception;
}
