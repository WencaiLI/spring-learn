https://docs.spring.io/spring-kafka/docs/current/reference/html/#introduction
## 1. 准备工作-doker上安装Zookepper与Kafka

https://developer.confluent.io/quickstart/kafka-docker/
### 1.1 创建`docker-compose.yml`
```yaml
---
version: '3'
services:
  zookeeper:
    image: confluentinc/cp-zookeeper:7.3.2
    container_name: zookeeper
    environment:
      ZOOKEEPER_CLIENT_PORT: 2181
      ZOOKEEPER_TICK_TIME: 2000

  broker:
    image: confluentinc/cp-kafka:7.3.2
    container_name: broker
    ports:
    # To learn about configuring Kafka for access across networks see
    # https://www.confluent.io/blog/kafka-client-cannot-connect-to-broker-on-aws-on-docker-etc/
      - "9092:9092"
    depends_on:
      - zookeeper
    environment:
      KAFKA_BROKER_ID: 1
      KAFKA_ZOOKEEPER_CONNECT: 'zookeeper:2181'
      KAFKA_LISTENER_SECURITY_PROTOCOL_MAP: PLAINTEXT:PLAINTEXT,PLAINTEXT_INTERNAL:PLAINTEXT
      KAFKA_ADVERTISED_LISTENERS: PLAINTEXT://localhost:9092,PLAINTEXT_INTERNAL://broker:29092
      KAFKA_OFFSETS_TOPIC_REPLICATION_FACTOR: 1
      KAFKA_TRANSACTION_STATE_LOG_MIN_ISR: 1
      KAFKA_TRANSACTION_STATE_LOG_REPLICATION_FACTOR: 1
```
### 1.2 执行`docker-compose.yml`
在`docker-compose.yml`父路径上执行：
```shell
docker compose up -d
```
## 1.pom.xml添加依赖
```xml
<dependency>
  <groupId>org.springframework.kafka</groupId>
  <artifactId>spring-kafka</artifactId>
</dependency>
```
## 
## 2.配置文件`properties.yml`
```yaml
spring:
  # kafka properties
  kafka:
    bootstrap-servers: 127.0.0.1:9092
    listener:
      type: batch
      missing-topics-fatal: false
    producer:
      key-serializer: org.apache.kafka.common.serialization.StringSerializer
      value-serializer: org.springframework.kafka.support.serializer.JsonSerializer
    consumer:
      group-id: "test-group"
      enable-auto-commit: false
      key-deserializer: org.apache.kafka.common.serialization.StringDeserializer
      value-deserializer: org.springframework.kafka.support.serializer.JsonDeserializer
      properties:
        spring:
          json:
            trusted:
              packages: com.lwc.springboot.kafka.dto
#            type:
#              mapping: dto:com.lwc.springboot.kafka.dto.KafkaMessageDTO
```

## 3.使用
### 3.1 自动序列化对象
依赖注入：
```java
  @Resource
  KafkaTemplate<String, KafkaMessageDTO> kafkaTemplate;
```
推送消息：
```java
 kafkaTemplate.send("topic_1",kafkaMessageDTO);
```
接收消息：
```java
@Component
public class KafkaMessageListener {
    @KafkaListener(topics = "topic_1")
    public void onMessage(String kafkaMessageDTO){
        System.out.println(kafkaMessageDTO);
    }
}
```
3.1 对应配置文件
```yaml
spring:
  # kafka properties
  kafka:
    bootstrap-servers: 127.0.0.1:9092
    listener:
      type: batch
      missing-topics-fatal: false
    producer:
      key-serializer: org.apache.kafka.common.serialization.StringSerializer
      value-serializer: org.springframework.kafka.support.serializer.JsonSerializer
    consumer:
      group-id: "test-group"
      enable-auto-commit: false
      key-deserializer: org.apache.kafka.common.serialization.StringDeserializer
      value-deserializer: org.springframework.kafka.support.serializer.JsonDeserializer
      properties:
        spring:
          json:
            trusted:
              packages: com.lwc.springboot.kafka.dto
```
### 3.2 JSON字符串方式传递
```java
  @Resource
  KafkaTemplate<String, String> kafkaTemplate;
```
推送消息：
```java
kafkaTemplate.send("topic_1", JSON.toJSONString(kafkaMessageDTO));
```
接收消息：
```java
@Component
public class KafkaMessageListener {
    @KafkaListener(topics = "topic_1")
    public void onMessage(String kafkaMessageDTO){
        KafkaMessageDTO kafkaMessageDTO1 = JSON.parseObject(kafkaMessageDTO, KafkaMessageDTO.class);
        System.out.println(kafkaMessageDTO1);
    }
}
```
3.2对应配置文件
```yaml
spring:
  kafka:
    bootstrap-servers: 127.0.0.1:9092
    listener:
      type: batch
      missing-topics-fatal: false
    producer:
      key-serializer: org.apache.kafka.common.serialization.StringSerializer
      value-serializer: org.apache.kafka.common.serialization.StringSerializer
    consumer:
      group-id: "test-group"
      enable-auto-commit: false
      key-deserializer: org.apache.kafka.common.serialization.StringDeserializer
      value-deserializer: org.apache.kafka.common.serialization.StringDeserializer
```