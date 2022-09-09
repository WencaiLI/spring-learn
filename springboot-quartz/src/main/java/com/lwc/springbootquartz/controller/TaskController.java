package com.lwc.springbootquartz.controller;

import com.lwc.springbootquartz.dto.Rets;
import com.lwc.springbootquartz.db.generated.entity.Task;
import com.lwc.springbootquartz.service.TaskService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * <p>
 * 定时任务 前端控制器
 * </p>
 *
 * @author liwencai
 * @since 2022-09-09
 */
@RestController
@RequestMapping("/task")
public class TaskController {
    @Autowired
    private TaskService taskService;

    /**
     * 获取定时任务管理列表
     */
    @RequestMapping(value = "/list")
    public Object list(Long id) {
        if(null == id) {
            return Rets.success(taskService.query());
        }else{
            return Rets.success(taskService.getById(id));
        }
    }

    /**
     * 新增定时任务管理
     */
    @RequestMapping(method = RequestMethod.POST)
    public Object add(@ModelAttribute Task task) {
        return Rets.success(taskService.save(task));
    }
}
