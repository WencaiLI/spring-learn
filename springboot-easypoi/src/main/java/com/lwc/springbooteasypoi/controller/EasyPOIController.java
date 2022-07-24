package com.lwc.springbooteasypoi.controller;

import com.lwc.springbooteasypoi.model.Student;
import com.lwc.springbooteasypoi.model.StudentEntity;
import com.lwc.springbooteasypoi.service.EasyPOIService;
import com.lwc.springbooteasypoi.utils.ExcelUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Auther: liwencai
 * @Date: 2022/7/24 20:55
 * @Description:
 */
@RestController
@RequestMapping("/springbootEasyPOI")
public class EasyPOIController {
    @Autowired
    EasyPOIService easyPOIService;

    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public void test(HttpServletResponse httpServletResponse) throws IOException {

        List<StudentEntity> studentList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            studentList.add(new StudentEntity(String.valueOf(i+1),"李文彩"+i,1,new Date(),new Date()));
        }
        ExcelUtils.exportExcel(studentList, "导出测试", "sheet1", StudentEntity.class, "fileName", httpServletResponse);
    }
}
