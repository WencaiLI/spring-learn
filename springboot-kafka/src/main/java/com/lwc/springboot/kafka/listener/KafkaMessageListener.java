package com.lwc.springboot.kafka.listener;

import com.alibaba.fastjson.JSON;
import com.lwc.springboot.kafka.dto.KafkaMessageDTO;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @author liwencai
 * @since 2023/4/17
 */
@Component
public class KafkaMessageListener {
    @KafkaListener(topics = "topic_1")
    public void onMessage(String kafkaMessageDTO){
        KafkaMessageDTO kafkaMessageDTO1 = JSON.parseObject(kafkaMessageDTO, KafkaMessageDTO.class);
        System.out.println(kafkaMessageDTO1);
    }
}
