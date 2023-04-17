package com.lwc.springboot.lombok;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author liwencai
 * @since 2023/4/15
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class UserExtend1 extends User{
    private String other;
}
