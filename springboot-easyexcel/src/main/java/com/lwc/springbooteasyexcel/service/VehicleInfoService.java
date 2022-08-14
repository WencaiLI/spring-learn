package com.lwc.springbooteasyexcel.service;

import com.lwc.springbooteasyexcel.dto.VehicleInfoExcelImportDTO;

import java.util.List;

/**
 * @Auther: liwencai
 * @Date: 2022/7/30 18:43
 * @Description:
 */
public interface VehicleInfoService {
    void batchImport(List<VehicleInfoExcelImportDTO> list);
}
