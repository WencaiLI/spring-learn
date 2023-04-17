package com.lwc.springboot.lombok;

/**
 * @author liwencai
 * @since 2023/4/15
 */
// 情景2.2
public class UserExtend2 extends User{
    private String other;

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }
}
