package com.lwc.springbootdozer.controller;

import com.lwc.springbootdozer.service.DozerServcie;
import com.lwc.springbootdozer.utils.BeanMapper;
import com.lwc.springbootdozer.vo.GoodsVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: liwencai
 * @Date: 2022/7/23 21:07
 * @Description:
 */
@RequestMapping("/dozer")
@RestController
public class DozerController {
    @Autowired
    DozerServcie dozerServcie;
    @Autowired
    BeanMapper beanMapper;

    @RequestMapping(value = "/beanMapper",method = RequestMethod.GET)
    public Object test(@RequestParam(name = "id")Integer id){
        GoodsVO result = beanMapper.map(dozerServcie.selectById(id), GoodsVO.class);
        return result;
    }
}
