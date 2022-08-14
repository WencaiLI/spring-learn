package com.lwc.springbootelasticsearch.pojo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * @Author: liwencai
 * @Date: 2022/8/14 16:26
 * @Description:
 */
@Document(indexName = "hotel")
@Data
public class Hotel {
    @Id
    private String id; // 对应Elasticsearch的_id
    private String title; // 对应索引中的title
    private String city;  // 对应索引中的city
    private String price; // 对应缩影中的price
}
