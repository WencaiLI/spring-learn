package com.lwc.springbootmapstruct;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * @Auther: liwencai
 * @Date: 2022/7/26 22:46
 * @Description: 商品品牌 转换 Demo Two
 */

@Mapper
public interface PmsBrandConvertDemoTwo {

    PmsBrandConvertDemoTwo INSTANCE = Mappers.getMapper(PmsBrandConvertDemoTwo.class);

    /**
     * 商品品牌 ItemDTO 转换商品品牌 entity
     *
     * @param brandItemDTO 商品品牌 ItemDTO
     * @return 商品品牌 entity
     */
    @Mapping(source = "bigPicture", target = "bigPic")
    PmsBrand convert(PmsBrandItemDTO brandItemDTO);
}
