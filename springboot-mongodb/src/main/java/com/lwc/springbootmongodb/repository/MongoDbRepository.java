package com.lwc.springbootmongodb.repository;

import com.lwc.springbootmongodb.entity.Comments;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author tycoding
 * @date 2019-03-19
 */
public interface MongoDbRepository extends MongoRepository<Comments, String> {
}
