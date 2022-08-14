package com.lwc.springbootlogstash;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: liwencai
 * @Date: 2022/8/9 16:46
 * @Description:
 */
@RestController
@Slf4j
@RequestMapping("/springboot-logstash")
public class Controller {
    @GetMapping("/infoLog")
    public void infoLog(){
        log.info("正常");
    }

    @GetMapping("/errorLog")
    public void errorLog(){
        log.error("出错");
    }
}
