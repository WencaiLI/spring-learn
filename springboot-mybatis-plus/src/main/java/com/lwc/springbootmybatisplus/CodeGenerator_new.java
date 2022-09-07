package com.lwc.springbootmybatisplus;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.baomidou.mybatisplus.generator.fill.Column;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Author: liwencai
 * @Date: 2022/9/7 22:36
 * @Description: 交互式生成 注意：scanner.apply()中应该填写提示信息，本类只做演示。如scanner.apply("设置生成路径")
 */
public class CodeGenerator_new {

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
                // 全局配置
                .globalConfig((scanner, builder) -> builder.author(scanner.apply(AUTHOR)).fileOverride().outputDir(OUTPUT_DIR))
                // 包配置
                .packageConfig((scanner, builder) -> builder.parent(scanner.apply(PACKAGE_NAME))
                        .moduleName(scanner.apply(MODULE_NAME))
                        .pathInfo(Collections.singletonMap(OutputFile.xml, scanner.apply(MAPPER_XML_PATH)))
                )
                // 策略配置
                .strategyConfig((scanner, builder) -> builder.addInclude(getTables(scanner.apply("all")))
                        .controllerBuilder().enableRestStyle().enableHyphenStyle()
                        .entityBuilder().enableLombok().addTableFills(
                                new Column("create_time", FieldFill.INSERT)
                        ).build())
                /*
                    模板引擎配置，默认 Velocity 可选模板引擎 Beetl 或 Freemarker
                   .templateEngine(new BeetlTemplateEngine())
                   .templateEngine(new FreemarkerTemplateEngine())
                 */
                .templateEngine(new FreemarkerTemplateEngine())
                .execute();



    }
    // 处理 all 情况
    protected static List<String> getTables(String tables){
        return "all".equals(tables) ? Collections.emptyList() : Arrays.asList(tables.split(","));
    }
}
