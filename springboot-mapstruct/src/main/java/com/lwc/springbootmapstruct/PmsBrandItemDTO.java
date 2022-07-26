package com.lwc.springbootmapstruct;

import lombok.Data;
import lombok.EqualsAndHashCode;
import java.io.Serializable;

/**
 * @Auther: liwencai
 * @Date: 2022/7/26 22:44
 * @Description: 商品品牌 ItemDTO
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class PmsBrandItemDTO implements Serializable {

    private String name;

    private String firstLetter;

    private Integer sort;

    private Integer factoryStatus;

    private Integer showStatus;

    private String logo;

    private String bigPicture;

    private String brandStory;
}