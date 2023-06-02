package com.lwc.springboothippo4j;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.concurrent.ThreadPoolExecutor;

@SpringBootTest
class SpringbootHippo4jApplicationTests {
    @Resource
    private ThreadPoolExecutor messageConsumeDynamicExecutor;

    @Resource
    private ThreadPoolExecutor messageProduceDynamicExecutor;



    @Test
    void contextLoads() {
        for (int i = 0; i < 100; i++) {
            int finalI = i;
            while (messageProduceDynamicExecutor.isTerminated()){
                messageProduceDynamicExecutor.execute(() -> System.out.println(finalI));
            }
            messageProduceDynamicExecutor.shutdown();
//            messageProduceDynamicExecutor.execute(() -> System.out.println(finalI));
        }

    }

}
