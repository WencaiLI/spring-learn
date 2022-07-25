## 添加依赖
```xml
<!-- redis client-->
<dependency>
    <groupId>redis.clients</groupId>
    <artifactId>jedis</artifactId>
</dependency>
```
## yml添加配置
```properties
#redis
redis.host=127.0.0.1
redis.port=6379
redis.timeout=3
#redis.password=123456
redis.poolMaxTotal=10
redis.poolMaxIdle=10
redis.poolMaxWait=3
```
## 读取配置信息
```java
@Component
@Data
@ConfigurationProperties(prefix="redis")
public class RedisConfigProperties {
    private String host;
    private int port;
    private int timeout;//秒
    private String password;
    private int poolMaxTotal;
    private int poolMaxIdle;
    private int poolMaxWait;//秒

}
```
## 配置RedisPool连接池
```java
@Configuration
public class RedisConfig {

    @Autowired
    RedisConfigProperties redisConfigProperties;

    @Bean
    public JedisPool JedisPoolFactory() {
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxIdle(redisConfigProperties.getPoolMaxIdle());
        poolConfig.setMaxTotal(redisConfigProperties.getPoolMaxTotal());
        poolConfig.setMaxWaitMillis(redisConfigProperties.getPoolMaxWait() * 1000);
        JedisPool jp = new JedisPool(poolConfig, redisConfigProperties.getHost(), redisConfigProperties.getPort(),
                redisConfigProperties.getTimeout()*1000, redisConfigProperties.getPassword(), 0);
        return jp;
    }
}
```
## 使用
```java
Jedis jedis = jedisPool.getResource();
jedis.set("jedis","jedis");
```