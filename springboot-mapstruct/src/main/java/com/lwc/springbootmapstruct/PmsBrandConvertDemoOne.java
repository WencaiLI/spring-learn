package com.lwc.springbootmapstruct;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * @Auther: liwencai
 * @Date: 2022/7/26 22:45
 * @Description: 商品品牌 转换 Demo One
 */
@Mapper(componentModel = "spring")
public interface  PmsBrandConvertDemoOne {

    /**
     * 商品品牌 ItemDTO 转换商品品牌 entity
     *
     * @param brandItemDTO 商品品牌 ItemDTO
     * @return 商品品牌 entity
     */
    @Mapping(source = "bigPicture", target = "bigPic")
    PmsBrand convert(PmsBrandItemDTO brandItemDTO);

}
