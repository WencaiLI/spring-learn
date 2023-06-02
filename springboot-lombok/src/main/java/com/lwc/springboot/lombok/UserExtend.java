package com.lwc.springboot.lombok;


import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author liwencai
 * @since 2023/4/15
 */
@Data
@EqualsAndHashCode(callSuper = true) // 见README.md情景二
public class UserExtend extends User {
    private String other;// TODO: 2023/4/15


}
