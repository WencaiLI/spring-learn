package com.lwc.springbooteasypoi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.Date;

/**
 * @Auther: liwencai
 * @Date: 2022/7/24 21:17
 * @Description:
 */
@Data
@AllArgsConstructor
public class Student {
    private String        id;
    private String        name;
    private int           sex;
    private Date birthday;

    private Date registrationDate;
}
