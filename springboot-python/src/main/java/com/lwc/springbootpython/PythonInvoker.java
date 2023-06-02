package com.lwc.springbootpython;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.ExecuteWatchdog;
import org.apache.commons.exec.PumpStreamHandler;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author liwencai
 * @since 2023/6/1
 */
@Slf4j
@Component
public class PythonInvoker {

    @Resource
    private PythonConfig pythonConfig;

    public static void main(String[] args) {
        Map<String, String> resultMap = new PythonInvoker().invokePython("D:\\test.py", "10000,1001 11111,2012");

        String result = resultMap.get("result");
        log.info(result);
        String error = resultMap.get("error");
        log.error(error);

        // 获取系统换行符
        String property = System.getProperty("line.separator");
        if (StringUtils.isNotBlank(result)) {
            // 按行获取结果
            System.out.println(Arrays.toString(result.split(property)));
            // 不分行
            System.out.println(result.replace(property, ""));
        }
    }

    /**
     * 获取主函数路径
     *
     * @return String 路径
     */
    public String getMainFilePath() {
        String pythonFileMain = pythonConfig.pythonFileMain;
        if (StringUtils.isBlank(pythonFileMain)) {
            throw new IllegalArgumentException("python脚本主函数不能为空！");
        }
        return pythonFileMain;
    }

    /**
     * python 程序调用
     *
     * @param path   主函数路径
     * @param params 参数
     * @return String[] 第一位为python脚本输出值 第二位为报错信息
     */
    public Map<String, String> invokePython(String path, String params) {
        Map<String, String> resultMap = new HashMap<>(2);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ByteArrayOutputStream errorOutputStream = new ByteArrayOutputStream();

        invoke(outputStream, errorOutputStream, null,null, "python", path, params);
        String out = new String(outputStream.toByteArray(), StandardCharsets.UTF_8);
        String error = new String(errorOutputStream.toByteArray(), StandardCharsets.UTF_8);
        resultMap.put("result", out);
        resultMap.put("error", error);
        return resultMap;
    }

    /**
     * 调用
     *
     * @param outputStream 输出信息输出流
     * @param errorStream  错误信息输出流
     * @param input        输入流 例：可以是文件流输入到文件中
     * @param watchdog     看门狗 例：可设置过期时间等
     * @param executable   执行程序 例：执行python命令就是python,执行java命令就是java
     * @param args         可变长参数
     */
    public void invoke(OutputStream outputStream, OutputStream errorStream, InputStream input, ExecuteWatchdog watchdog, String executable, String... args) {
        //
        if (StringUtils.isBlank(executable)) {
            throw new IllegalArgumentException("可执行程序不能为空！");
        }
        if (args.length == 0) {
            throw new IllegalArgumentException("参数不能为空！");
        }
        // 生成可执行命令行
        CommandLine commandline = new CommandLine(executable);
        for (String argument : args) {
            commandline.addArgument(argument);
        }

        // 生成执行器
        PumpStreamHandler streamHandler = new PumpStreamHandler(outputStream, errorStream, input);
        DefaultExecutor exec = new DefaultExecutor();
        exec.setExitValues(null);
        exec.setStreamHandler(streamHandler);
        exec.setWatchdog(watchdog);
        try {
            exec.execute(commandline);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
