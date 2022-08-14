package com.lwc.springbootelasticsearch;

import com.lwc.springbootelasticsearch.pojo.Hotel;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @Author: liwencai
 * @Date: 2022/8/14 16:32
 * @Description:
 */
public interface EsRepository extends CrudRepository<Hotel,String> {
    List<Hotel> findByTitleLike(String title);
}
