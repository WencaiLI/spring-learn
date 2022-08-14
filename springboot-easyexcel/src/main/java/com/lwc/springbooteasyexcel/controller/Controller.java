package com.lwc.springbooteasyexcel.controller;

import com.alibaba.excel.EasyExcel;
import com.lwc.springbooteasyexcel.ExcelListener;
import com.lwc.springbooteasyexcel.dto.VehicleInfoExcelImportDTO;
import com.lwc.springbooteasyexcel.service.VehicleInfoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * @Auther: liwencai
 * @Date: 2022/7/31 17:32
 * @Description:
 */
@RestController
@RequestMapping("/vehicle/info")
public class Controller {

    @Resource
    VehicleInfoService vehicleInfoService;

    @RequestMapping("/batchImport")
    public String importexcel(@RequestParam(value = "excelFile") MultipartFile file) throws IOException {
        EasyExcel.read(file.getInputStream(), VehicleInfoExcelImportDTO.class, new ExcelListener(vehicleInfoService)).sheet().doRead();
        return "success";
    }
}
