package com.lwc.springbootpython;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.PumpStreamHandler;
import org.apache.tomcat.util.http.fileupload.ByteArrayOutputStream;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

<<<<<<< HEAD
import java.io.IOException;
=======
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
>>>>>>> 52cc4fc (添加)

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
<<<<<<< HEAD
=======

    @RequestMapping(value ="/test_1",method = RequestMethod.GET)
    public void test1(){
        String command = "D:\\PythonProjects\\connection.py";
        String params = "world";
        String[] cmd = new String[]{"python",command,params};
        try {
            Process process = Runtime.getRuntime().exec(cmd);
            String charset = "UTF-8";
            // error的要单独开一个线程处理。其实最好分成两个子线程分别处理标准输出流和错误输出流
            ProcessStream stderr = new ProcessStream(process.getErrorStream(), "ERROR", charset);
            stderr.start();
            // 获取标准输出流的内容
            BufferedReader stdout = new BufferedReader(new InputStreamReader(process.getInputStream(), charset));
            String line = null;
            StringBuilder rtnSb = new StringBuilder();
            Map<String, String>  rtnMap = new HashMap<>();
            while ((line = stdout.readLine()) != null) {
                rtnSb.append(line).append("\r\n");
            }
            rtnMap.put("result",rtnSb.toString());
            rtnMap.put("error",stderr.getContent());
            //关闭流
            stdout.close();
            int status = process.waitFor();
            if (status != 0) {
                System.out.println("return value:"+status);
            }
            System.out.println(rtnMap);
            process.destroy();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
>>>>>>> 52cc4fc (添加)
}
