package com.lwc.springbootmybatisplus.service.impl;

import com.lwc.springbootmybatisplus.entity.Task;
import com.lwc.springbootmybatisplus.mapper.TaskMapper;
import com.lwc.springbootmybatisplus.service.ITaskService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 定时任务 服务实现类
 * </p>
 *
 * @author liwencai
 * @since 2022-09-07
 */
@Service
public class TaskServiceImpl extends ServiceImpl<TaskMapper, Task> implements ITaskService {

}
