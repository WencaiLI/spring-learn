package com.lwc.springboot.lombok;

import lombok.Data;

/**
 * @author liwencai
 * @since 2023/4/15
 */
@Data
public class UserAnnoData extends User {
    public static final String s = "x";
    private String other;

    @Deprecated
    public static void main(String[] args) {

    }
}
