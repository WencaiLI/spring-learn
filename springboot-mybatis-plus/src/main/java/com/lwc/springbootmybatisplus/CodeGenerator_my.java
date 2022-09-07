package com.lwc.springbootmybatisplus;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Collections;

/**
 * @Author: liwencai
 * @Date: 2022/9/7 22:40
 * @Description: 快速生成
 */
public class CodeGenerator_my {
    private final static String JDBC_URL = "jdbc:mysql://127.0.0.1:3306/springboot_quartz?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone =Asia/Shanghai";
    private final static String JDBC_USERNAME = "root";
    private final static String JDBC_PASSWORD = "root";
    private final static String AUTHOR = "liwencai";

    /**
     * 自动生成文件位置
     */
    private final static String OUTPUT_DIR = "C:\\Users\\WenCaiLi\\Desktop\\netty redis zookeeper\\spring-learn\\springboot-mybatis-plus\\src\\main\\java";

    /**
     * 对应 Group 分组名
     */
    private final static String PACKAGE_NAME = "com.lwc";

    /**
     * 对应 Artifact
     */
    private final static String MODULE_NAME = "springbootmybatisplus";

    /**
     * mapper xml 生成路径
     */
    private final static String MAPPER_XML_PATH = "C:\\Users\\WenCaiLi\\Desktop\\netty redis zookeeper\\spring-learn\\springboot-mybatis-plus\\src\\main\\resources\\mybatis-plus\\mapper";


    public static void main(String[] args) {
        FastAutoGenerator.create(JDBC_URL,JDBC_USERNAME,JDBC_PASSWORD)
                .globalConfig(builder -> {
                    builder.author(AUTHOR) // 设置作者
                            .enableSwagger() // 开启swagger模式
                            .fileOverride() // 覆盖已生成的文件
                            .outputDir(OUTPUT_DIR);
                })
                .packageConfig(builder -> {
                    builder.parent(PACKAGE_NAME) // 设置父包名
                            .moduleName(MODULE_NAME) // 设置父包模块名
                            .pathInfo(Collections.singletonMap(OutputFile.xml, MAPPER_XML_PATH)); // 设置mapperXml生成路径
                }).strategyConfig(builder -> {
                     builder.addInclude("tbl_task") // 设置需要生成的表名
                            .addTablePrefix("tbl_", "c_"); // 设置过滤表前缀
        })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }
}
