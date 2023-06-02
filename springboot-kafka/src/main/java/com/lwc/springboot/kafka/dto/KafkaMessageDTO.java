package com.lwc.springboot.kafka.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author liwencai
 * @since 2023/4/17
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class KafkaMessageDTO {
    private String id;
    private String name;
}
