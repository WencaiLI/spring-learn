package com.lwc.springbootquartz.service.impl;

import com.lwc.springbootquartz.db.generated.entity.Task;
import com.lwc.springbootquartz.db.generated.mapper.TaskMapper;
import com.lwc.springbootquartz.service.TaskService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 定时任务 服务实现类
 * </p>
 *
 * @author liwencai
 * @since 2022-09-09
 */
@Service
public class TaskServiceImpl extends ServiceImpl<TaskMapper, Task> implements TaskService {

}
