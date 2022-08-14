package com.lwc.springbootelasticsearch.Service;

import com.lwc.springbootelasticsearch.EsRepository;
import com.lwc.springbootelasticsearch.pojo.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: liwencai
 * @Date: 2022/8/14 16:34
 * @Description:
 */
@Service
public class EsService {
    @Autowired
    EsRepository esRepository;

    public List<Hotel> getHotelFromTitle(String keyword){
        return esRepository.findByTitleLike(keyword);
    }
}
