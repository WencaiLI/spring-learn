package com.lwc.springbootelasticsearch.controller;

import com.lwc.springbootelasticsearch.Service.EsService;
import com.lwc.springbootelasticsearch.pojo.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: liwencai
 * @Date: 2022/8/14 16:36
 * @Description:
 */
@RestController
public class TestController {
    @Autowired
    EsService esService;
    @RequestMapping(value = "/test")
    public String getRec() throws Exception{
        List<Hotel> hotelList = esService.getHotelFromTitle("再来");
        if (hotelList != null && hotelList.size()>0){
            return hotelList.toString();
        }else {
            return "no data.";
        }
    }
}
