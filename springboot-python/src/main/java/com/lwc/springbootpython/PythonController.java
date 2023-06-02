package com.lwc.springbootpython;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;

/**
 * @Author: liwencai
 * @Date: 2022/8/24 13:37
 * @Description: python插件测试
 */
@Slf4j
@RestController
@RequestMapping(value ="/python")
public class PythonController {
    @Autowired
    PythonInvoker projectInvokeUtil;
    @RequestMapping(value ="/test",method = RequestMethod.GET)
    public Object test() throws IOException, InterruptedException {
        return projectInvokeUtil.invokePython(projectInvokeUtil.getMainFilePath(), "111,11,,1,1,,,1,1,1,1,");
    }
}
