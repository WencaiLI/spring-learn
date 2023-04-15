接入流程
Nacos、Apollo、Zookeeper、ETCD、Polaris 配置中心任选其一。
```java
https://hippo4j.cn/docs/user_docs/getting_started/config/hippo4j-config-start
```
hippo4j 配置
```xml
<dependency>
    <groupId>cn.hippo4j</groupId>
    <artifactId>hippo4j-config-spring-boot-starter</artifactId>
    <version>1.4.3-upgrade</version>
</dependency>
```
启动类上添加注解 @EnableDynamicThreadPool。
```java
@SpringBootApplication
@EnableDynamicThreadPool
public class ExampleApplication {
    public static void main(String[] args) {
        SpringApplication.run(ExampleApplication.class, args);
    }
}
```


SpringBoot 应用配置文件添加：
```yaml
server:
  port: 8090
  servlet:
    context-path: /example

spring:
  profiles:
    active: dev

  dynamic:
    thread-pool:
      # 是否开启动态线程池
      enable: true
      # 是否打印 banner
      banner: true
      # 是否开启线程池数据采集，对接 Micrometer、ES、Log 等
      collect: true
      # 检查线程池状态，是否达到报警条件，单位毫秒
      check-state-interval: 3000
      # 通知报警平台，请替换为自己创建的群机器人
      notify-platforms:
        - platform: 'WECHAT'
          token: xxx
        - platform: 'DING'
          token: xxx
          secret: xxx  # 加签专属
        - platform: 'LARK'
          token: xxx
      # Nacos、Apollo、Zookeeper、ETCD、Polaris 任选其一
      nacos:
        data-id: xxx
        group: xxx
      apollo:
        namespace: xxxx
      # 配置中心文件格式
      config-file-type: yml
      # tomcat、undertow、jetty 三种容器线程池，任选其一
      undertow:
        core-pool-size: 100
        maximum-pool-size: 200
        keep-alive-time: 1000
      # 全局通知配置-是否报警
      alarm: true
      # 活跃度报警阈值；假设线程池最大线程数 10，当线程数达到 8 发起报警
      active-alarm: 80
      # 容量报警阈值；假设阻塞队列容量 100，当容量达到 80 发起报警
      capacity-alarm: 80
      # 报警间隔，同一线程池下同一报警纬度，在 interval 时间内只会报警一次，单位秒
      alarm-interval: 8
      # 企业微信填写用户 ID（填写其它将无法达到 @ 效果）、钉钉填手机号、飞书填 ou_ 开头唯一 ID
      receives: xxx
      # 动态线程池列表
      executors:
        - thread-pool-id: 'message-consume'
          # 核心线程数
          core-pool-size: 1
          # 最大线程数
          maximum-pool-size: 1
          # 阻塞队列名称，参考 BlockingQueueTypeEnum，支持 SPI
          blocking-queue: 'LinkedBlockingQueue'
          # 阻塞队列大小
          queue-capacity: 1
          # 执行超时时间，超过此时间发起报警，单位毫秒
          execute-time-out: 1000
          # 拒绝策略名称，参考 RejectedPolicyTypeEnum，支持 SPI
          rejected-handler: 'AbortPolicy'
          # 线程存活时间，单位秒
          keep-alive-time: 1024
          # 是否允许核心线程超时
          allow-core-thread-time-out: true
          # 线程工厂名称前缀
          thread-name-prefix: 'message-consume'
          # 是否报警
          alarm: true
          # 活跃度报警阈值；假设线程池最大线程数 10，当线程数达到 8 发起报警
          active-alarm: 80
          # 容量报警阈值；假设阻塞队列容量 100，当容量达到 80 发起报警
          capacity-alarm: 80
          # 通知配置，线程池中通知配置如果存在，则会覆盖全局通知配置
          notify:
            # 报警间隔，同一线程池下同一报警纬度，在 interval 时间内只会报警一次，单位分钟
            interval: 8
            # 企业微信填写用户 ID（填写其它将无法达到 @ 效果）、钉钉填手机号、飞书填 ou_ 开头唯一 ID
            receives: xxx
        - thread-pool-id: 'message-produce'
          core-pool-size: 1
          maximum-pool-size: 1
          queue-capacity: 1
          execute-time-out: 1000
          blocking-queue: 'LinkedBlockingQueue'
          rejected-handler: 'AbortPolicy'
          keep-alive-time: 1024
          allow-core-thread-time-out: true
          thread-name-prefix: 'message-consume'
          alarm: true
          active-alarm: 80
          capacity-alarm: 80
          notify:
            interval: 8
            receives: xxx
```


ThreadPoolExecutor 适配
添加线程池配置类，通过 @DynamicThreadPool 注解修饰。threadPoolId 为服务端创建的线程池 ID。
```java
package cn.hippo4j.example;

import cn.hippo4j.core.executor.DynamicThreadPool;
import cn.hippo4j.core.executor.support.ThreadPoolBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.concurrent.ThreadPoolExecutor;

@Configuration
public class ThreadPoolConfig {

    @Bean
    @DynamicThreadPool
    public ThreadPoolExecutor messageConsumeDynamicExecutor() {
        String threadPoolId = "message-consume";
        ThreadPoolExecutor messageConsumeDynamicExecutor = ThreadPoolBuilder.builder()
                .threadFactory(threadPoolId)
                .threadPoolId(threadPoolId)
                .dynamicPool()
                .build();
        return messageConsumeDynamicExecutor;
    }

    @Bean
    @DynamicThreadPool
    public ThreadPoolExecutor messageProduceDynamicExecutor() {
        String threadPoolId = "message-produce";
        ThreadPoolExecutor messageProduceDynamicExecutor = ThreadPoolBuilder.builder()
                .threadFactory(threadPoolId)
                .threadPoolId(threadPoolId)
                .dynamicPool()
                .build();
        return messageProduceDynamicExecutor;
    }

}
```

通过 ThreadPoolBuilder 构建动态线程池，只有 threadFactory、threadPoolId 为必填项，其它参数会从配置中心拉取。

项目中使用上述定义的动态线程池，如下所示：
```java
@Resource
private ThreadPoolExecutor messageConsumeDynamicExecutor;

messageConsumeDynamicExecutor.execute(() -> xxx);

@Resource
private ThreadPoolExecutor messageProduceDynamicExecutor;

messageProduceDynamicExecutor.execute(() -> xxx);
```

外接钉钉
需要创建一个群，
再创建一个机器人，
获取https://oapi.dingtalk.com/robot/send?access_token=4a582a588a161d6e3a1bd1de7eea9ee9f562cdfcbe56b6e72029e7fd512b2eae
填写就行
```yaml
spring:
  profiles:
    active: dev
  application:
    name: dynamic-threadpool-example
  dynamic:
    thread-pool:
      notifys:
        - type: DING
          url: https://oapi.dingtalk.com/robot/send?access_token=
          # 此处可以选择自己的钉钉群
          token: 4a582a588a161d6e3a1bd1de7eea9ee9f562cdfcbe56b6e72029e7fd512b2eae
          # 通知时 @ 人员
          receives: '15601166691'
      # 报警发送间隔
      alarm-interval: 30
      # 服务端地址
      server-addr: http://localhost:6691
      # 租户 id, 对应 tenant 表
      namespace: prescription
      # 项目 id, 对应 item 表
      item-id: ${spring.application.name}

```