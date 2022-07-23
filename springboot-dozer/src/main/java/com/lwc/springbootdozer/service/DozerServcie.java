package com.lwc.springbootdozer.service;

import com.lwc.springbootdozer.model.Goods;

/**
 * @Auther: liwencai
 * @Date: 2022/7/23 21:09
 * @Description:
 */
public interface DozerServcie {
    Goods selectById(Integer id);
}
