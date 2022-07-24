package com.lwc.springbooteasypoi.model;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;

import java.io.Serializable;

/**
 * @Auther: liwencai
 * @Date: 2022/7/24 21:04
 * @Description:
 */
@ExcelTarget("teacherEntity")
public class TeacherEntity implements Serializable {
    private String id;
    /**
     * name
     */
    @Excel(name = "主讲老师_major,代课老师_absent", orderNum = "1", isImportField = "true_major,true_absent")
    private String name;
}