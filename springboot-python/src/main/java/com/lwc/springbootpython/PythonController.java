package com.lwc.springbootpython;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.PumpStreamHandler;
import org.apache.tomcat.util.http.fileupload.ByteArrayOutputStream;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * @Author: liwencai
 * @Date: 2022/8/24 13:37
 * @Description: python插件测试
 */
@Slf4j
@RestController
@RequestMapping(value ="/python")
public class PythonController {
    private static final String PATH = "D:\\PythonProjects\\hello.py";
//private static final String PATH = "C:\\Users\\WenCaiLi\\Desktop\\netty redis zookeeper\\spring-learn\\springboot-python\\target\\classes\\python\\hello.py";
    @RequestMapping(value ="/test",method = RequestMethod.GET)
    public Object test() throws IOException, InterruptedException {
        final String line = "python " + PATH;
        final CommandLine cmdLine = CommandLine.parse(line);

        try (final ByteArrayOutputStream baos = new ByteArrayOutputStream())
        {
            final PumpStreamHandler streamHandler = new PumpStreamHandler(baos);

            final DefaultExecutor executor = new DefaultExecutor();
            executor.setStreamHandler(streamHandler);

            final int exitCode = executor.execute(cmdLine);

            log.info("调用Python脚本的执行结果: {}.", exitCode == 0 ? "成功" : "失败");
            log.info(baos.toString().trim());
        }
        catch (final IOException e)
        {
            log.error("调用Python脚本出错", e);
        }
        return null;
    }
}
