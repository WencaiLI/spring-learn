package com.lwc.springbootmongodb;

import org.kweny.carefree.mongodb.EnableMongoCarefree;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;

@EnableMongoCarefree
@SpringBootApplication(exclude = {MongoAutoConfiguration.class, MongoDataAutoConfiguration.class})
public class SpringbootMongodbApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootMongodbApplication.class, args);
    }

}
