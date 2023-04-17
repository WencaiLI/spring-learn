package com.lwc.springboot.kafka.controller;

import com.alibaba.fastjson.JSON;
import com.lwc.springboot.kafka.dto.KafkaMessageDTO;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author liwencai
 * @since 2023/4/17
 */
@RestController
@RequestMapping("springboot-kafka")
public class KafkaController {

    @Resource
    KafkaTemplate<String, String> kafkaTemplate;

    @GetMapping("/push")
    public void push(@RequestBody KafkaMessageDTO kafkaMessageDTO){
        kafkaTemplate.send("topic_1", JSON.toJSONString(kafkaMessageDTO));
    }

    @GetMapping("/pull")
    public void pull(){

    }
}
