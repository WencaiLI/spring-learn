package com.lwc.springbootquartz.db.generated.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>
 * 定时任务
 * </p>
 *
 * @author liwencai
 * @since 2022-09-09
 */
@TableName("tbl_task")
@ApiModel(value = "Task对象", description = "定时任务")
@Data
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
}
