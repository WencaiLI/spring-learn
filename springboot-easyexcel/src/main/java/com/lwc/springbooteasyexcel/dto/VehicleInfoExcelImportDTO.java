package com.lwc.springbooteasyexcel.dto;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @Auther: liwencai
 * @Date: 2022/7/30 21:59
 * @Description: VehicleInfo导入DTO
 */
public class VehicleInfoExcelImportDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 车牌号
     */
    @ColumnWidth(20)
    @ExcelProperty(value = "车牌号",index = 0)
    private String carNumber;

    /**
     * 所属类别名称
     */
    @ColumnWidth(20)
    @ExcelProperty(value = "所属类别",index = 1)
    private Long vehicleCategoryName;

    /**
     * 厂牌型号
     */
    @ColumnWidth(20)
    @ExcelProperty(value = "厂牌型号",index = 2)
    private String model;

    /**
     * 发动机号
     */
    @ColumnWidth(20)
    @ExcelProperty(value = "发动机号",index = 2)
    private String engineNumber;

    /**
     * 车架号
     */
    @ColumnWidth(20)
    @ExcelProperty(value = "车架号",index = 2)
    private String frameNumber;

    /**
     * 车身颜色
     */
    @ColumnWidth(20)
    @ExcelProperty(value = "车身颜色",index = 2)
    private String color;

    /**
     * 车辆照片名称
     */
    private String carImage;

    /**
     * 车辆照片url
     */
    private String carImageUrl;

    /**
     * 车辆行驶本照片名称
     */
    private String drivingBookImage;

    /**
     * 车辆行驶本照片url
     */
    private String drivingBookImageUrl;

    /**
     * 经销商
     */
    @ColumnWidth(20)
    @ExcelProperty(value = "经销商",index = 2)
    private String distributor;

    /**
     * 出厂日期
     */
    @ColumnWidth(20)
    @ExcelProperty(value = "出厂日期",index = 2)
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private LocalDateTime outDate;

    /**
     * 购买日期
     */
    @ColumnWidth(20)
    @ExcelProperty(value = "购买日期",index = 2)
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private LocalDateTime buyDate;

    /**
     * 购买价格
     */
    @ColumnWidth(20)
    @ExcelProperty(value = "购买价格",index = 2)
    private BigDecimal price;

    /**
     * 保险说明
     */
    @ColumnWidth(20)
    @ExcelProperty(value = "保险说明",index = 2)
    private String insurance;

    /**
     * 维保说明
     */
    @ColumnWidth(20)
    @ExcelProperty(value = "维保说明",index = 2)
    private String maintenance;

    /**
     * 描述
     */
    @ColumnWidth(20)
    @ExcelProperty(value = "公车描述",index = 2)
    private String description;
}
