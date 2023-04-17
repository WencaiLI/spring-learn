package com.lwc.springboot.kafka;

import com.lwc.springboot.kafka.dto.KafkaMessageDTO;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;

@SpringBootApplication
public class SpringbootKafkaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootKafkaApplication.class, args);
    }

//    @KafkaListener(topics = "topic_1")
//    public void onMessage(KafkaMessageDTO kafkaMessageDTO){
//        System.out.println(kafkaMessageDTO);
//    }
}
