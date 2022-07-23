package com.lwc.springbootdozer.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Auther: liwencai
 * @Date: 2022/7/23 21:38
 * @Description:
 */
@Data
@AllArgsConstructor
public class Goods {
    private Integer goodsId; // 商品价格
    private String name; // 商品名称
    private Long price; // 商品价格
}
