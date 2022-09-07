package com.lwc.springbootmybatisplus.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 定时任务
 * </p>
 *
 * @author liwencai
 * @since 2022-09-07
 */
@TableName("tbl_task")
@ApiModel(value = "Task对象", description = "定时任务")
public class Task implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("创建人")
    private Long createBy;

    @ApiModelProperty("创建时间/注册时间")
    private LocalDateTime createTime;

    @ApiModelProperty("最后更新人")
    private Long modifyBy;

    @ApiModelProperty("最后更新时间")
    private LocalDateTime modifyTime;

    @ApiModelProperty("是否允许并发")
    private Integer concurrent;

    @ApiModelProperty("定时规则")
    private String cron;

    @ApiModelProperty("执行参数")
    private String data;

    @ApiModelProperty("是否禁用")
    private Integer disabled;

    @ApiModelProperty("执行时间")
    private LocalDateTime execAt;

    @ApiModelProperty("执行结果")
    private String execResult;

    @ApiModelProperty("执行类")
    private String jobClass;

    @ApiModelProperty("任务组名")
    private String jobGroup;

    @ApiModelProperty("任务名")
    private String name;

    @ApiModelProperty("任务说明")
    private String note;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }
    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }
    public Long getModifyBy() {
        return modifyBy;
    }

    public void setModifyBy(Long modifyBy) {
        this.modifyBy = modifyBy;
    }
    public LocalDateTime getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(LocalDateTime modifyTime) {
        this.modifyTime = modifyTime;
    }
    public Integer getConcurrent() {
        return concurrent;
    }

    public void setConcurrent(Integer concurrent) {
        this.concurrent = concurrent;
    }
    public String getCron() {
        return cron;
    }

    public void setCron(String cron) {
        this.cron = cron;
    }
    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
    public Integer getDisabled() {
        return disabled;
    }

    public void setDisabled(Integer disabled) {
        this.disabled = disabled;
    }
    public LocalDateTime getExecAt() {
        return execAt;
    }

    public void setExecAt(LocalDateTime execAt) {
        this.execAt = execAt;
    }
    public String getExecResult() {
        return execResult;
    }

    public void setExecResult(String execResult) {
        this.execResult = execResult;
    }
    public String getJobClass() {
        return jobClass;
    }

    public void setJobClass(String jobClass) {
        this.jobClass = jobClass;
    }
    public String getJobGroup() {
        return jobGroup;
    }

    public void setJobGroup(String jobGroup) {
        this.jobGroup = jobGroup;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "Task{" +
            "id=" + id +
            ", createBy=" + createBy +
            ", createTime=" + createTime +
            ", modifyBy=" + modifyBy +
            ", modifyTime=" + modifyTime +
            ", concurrent=" + concurrent +
            ", cron=" + cron +
            ", data=" + data +
            ", disabled=" + disabled +
            ", execAt=" + execAt +
            ", execResult=" + execResult +
            ", jobClass=" + jobClass +
            ", jobGroup=" + jobGroup +
            ", name=" + name +
            ", note=" + note +
        "}";
    }
}
