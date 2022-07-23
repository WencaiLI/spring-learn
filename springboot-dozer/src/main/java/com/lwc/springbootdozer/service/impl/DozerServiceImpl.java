package com.lwc.springbootdozer.service.impl;

import com.lwc.springbootdozer.model.Goods;
import com.lwc.springbootdozer.service.DozerServcie;
import org.springframework.stereotype.Service;

/**
 * @Auther: liwencai
 * @Date: 2022/7/23 21:09
 * @Description:
 */
@Service
public class DozerServiceImpl implements DozerServcie {

    @Override
    public Goods selectById(Integer id) {
        Goods goods = new Goods(1,"服饰",100L);
        return goods;
    }
}
