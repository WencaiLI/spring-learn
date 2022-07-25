## 依赖引入

```xml
<!-- druid -->
<dependency>
    <groupId>com.alibaba</groupId>
    <artifactId>druid-spring-boot-starter</artifactId>
    <version>1.1.22</version>
</dependency>    
```

## yml配置

```yaml
spring:
  datasource:
    type: com.alibaba.druid.pool.DruidDataSource
    url: jdbc:mysql://127.0.0.1:3306/springboot-druid?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone =Asia/Shanghai
    username: root
    password: root
    druid:
      driver-class-name: com.mysql.cj.jdbc.Driver
      initialSize: 5
      minIdle: 5
      maxActive: 20
      maxWait: 60000
      timeBetweenEvictionRunsMillis: 60000
      minEvictableIdleTimeMillis: 300000
      validationQuery: SELECT1FROMDUAL
      testWhileIdle: true
      testOnBorrow: false
      testOnReturn: false
      ## 配置DruidStatViewServlet
      stat-view-servlet:
        enabled: true
        url-pattern: "/druid/*"
        ## IP白名单(没有配置或者为空，则允许所有访问)
        allow: 127.0.0.1
        ## IP黑名单 (存在共同时，deny优先于allow)
        ## deny: 192.168.1.100
        ##  禁用HTML页面上的“Reset All”功能
        reset-enable: false
        ## 登录名
        login-username: admin
        ## 登录密码
        login-password: 123456
      ## 配置DruidStatFilter
      web-stat-filter:
        enabled: true
        url-pattern: "/*"
        exclusions: "*.js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico,/druid/*"
      filter:
        #配置StatFilter (SQL监控配置)
        stat:
          enabled: true #开启 SQL 监控
          slow-sql-millis: 1000 #慢查询
          log-slow-sql: true #记录慢查询 SQL
        #配置WallFilter (防火墙配置)
        wall:
          enabled: true #开启防火墙
          config:
            update-allow: true #允许更新操作
            drop-table-allow: false #禁止删表操作
            insert-allow: true #允许插入操作
            delete-allow: true #删除数据操作
      ## 通过connectProperties属性来打开mergeSql功能；慢SQL记录
      connect-properties: druid.stat.mergeSql\=true;druid.stat.slowSqlMillis\=5000
```
## java 配置（在yml配置不全时）
```java
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import com.alibaba.druid.support.spring.stat.DruidStatInterceptor;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.JdkRegexpMethodPointcut;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * @Auther: liwencai
 * @Date: 2022/7/25 09:57
 * @Description:
 */
@Configuration
public class DruidConfiguration {

    @Bean
    public ServletRegistrationBean druidServlet() {
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
        // IP白名单
        servletRegistrationBean.addInitParameter("allow", "192.168.*");
        // IP黑名单(共同存在时，deny优先于allow)
        //dservletRegistrationBean.addInitParameter("deny", "192.168.1.100");
        //控制台管理用户
        servletRegistrationBean.addInitParameter("loginUsername", "admin");
        servletRegistrationBean.addInitParameter("loginPassword", "admin");
        //是否能够重置数据 禁用HTML页面上的“Reset All”功能
        servletRegistrationBean.addInitParameter("resetEnable", "false");
        return servletRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new WebStatFilter());
        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
        return filterRegistrationBean;
    }

    /* spring监控 */
    @Bean
    public DruidStatInterceptor druidStatInterceptor() {
        DruidStatInterceptor dsInterceptor = new DruidStatInterceptor();
        return dsInterceptor;
    }

    @Bean
    @Scope("prototype")
    public JdkRegexpMethodPointcut druidStatPointcut() {
        JdkRegexpMethodPointcut pointcut = new JdkRegexpMethodPointcut();
        pointcut.setPattern("com.softdev.cms.controller.*");
        pointcut.setPattern("com.softdev.cms.mapper.*");
        return pointcut;
    }

    @Bean
    public DefaultPointcutAdvisor druidStatAdvisor(DruidStatInterceptor druidStatInterceptor, JdkRegexpMethodPointcut druidStatPointcut) {
        DefaultPointcutAdvisor defaultPointAdvisor = new DefaultPointcutAdvisor();
        defaultPointAdvisor.setPointcut(druidStatPointcut);
        defaultPointAdvisor.setAdvice(druidStatInterceptor);
        return defaultPointAdvisor;
    }
    /* spring监控结束 */

}
```
## 访问地址

```
http://127.0.0.1:8080/druid
```



