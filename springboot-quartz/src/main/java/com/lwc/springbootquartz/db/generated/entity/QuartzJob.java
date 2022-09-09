package com.lwc.springbootquartz.db.generated.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

/**
 * @Author: liwencai
 * @Date: 2022/9/9 14:50
 * @Description:
 */
@Data
public class QuartzJob implements Serializable {
    private String jobId;
    private String jobName;
    private String jobGroup;
    private String jobClass;
    private String description;
    private String cronExpression;
    private boolean concurrent;
    private String jobStatus;
    private Date nextTime;
    private Date previousTime;
    private boolean disabled;
    private Map<String, Object> dataMap;
}
