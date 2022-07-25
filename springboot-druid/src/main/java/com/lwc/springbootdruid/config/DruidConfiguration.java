//package com.lwc.springbootdruid.config;
//
///**
// * @Auther: liwencai
// * @Date: 2022/7/25 09:57
// * @Description:
// */
//import com.alibaba.druid.support.http.StatViewServlet;
//import com.alibaba.druid.support.http.WebStatFilter;
//import com.alibaba.druid.support.spring.stat.DruidStatInterceptor;
//import org.springframework.aop.support.DefaultPointcutAdvisor;
//import org.springframework.aop.support.JdkRegexpMethodPointcut;
//import org.springframework.boot.web.servlet.FilterRegistrationBean;
//import org.springframework.boot.web.servlet.ServletRegistrationBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Scope;
//
//@Configuration
//public class DruidConfiguration {
//
//    @Bean
//    public ServletRegistrationBean druidServlet() {
//        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
//        // IP白名单
//        servletRegistrationBean.addInitParameter("allow", "192.168.*");
//        // IP黑名单(共同存在时，deny优先于allow)
//        //dservletRegistrationBean.addInitParameter("deny", "192.168.1.100");
//        //控制台管理用户
//        servletRegistrationBean.addInitParameter("loginUsername", "admin");
//        servletRegistrationBean.addInitParameter("loginPassword", "admin");
//        //是否能够重置数据 禁用HTML页面上的“Reset All”功能
//        servletRegistrationBean.addInitParameter("resetEnable", "false");
//        return servletRegistrationBean;
//    }
//
//    @Bean
//    public FilterRegistrationBean filterRegistrationBean() {
//        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new WebStatFilter());
//        filterRegistrationBean.addUrlPatterns("/*");
//        filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
//        return filterRegistrationBean;
//    }
//
//    /* spring监控 */
//    @Bean
//    public DruidStatInterceptor druidStatInterceptor() {
//        DruidStatInterceptor dsInterceptor = new DruidStatInterceptor();
//        return dsInterceptor;
//    }
//
//    @Bean
//    @Scope("prototype")
//    public JdkRegexpMethodPointcut druidStatPointcut() {
//        JdkRegexpMethodPointcut pointcut = new JdkRegexpMethodPointcut();
//        pointcut.setPattern("com.softdev.cms.controller.*");
//        pointcut.setPattern("com.softdev.cms.mapper.*");
//        return pointcut;
//    }
//
//    @Bean
//    public DefaultPointcutAdvisor druidStatAdvisor(DruidStatInterceptor druidStatInterceptor, JdkRegexpMethodPointcut druidStatPointcut) {
//        DefaultPointcutAdvisor defaultPointAdvisor = new DefaultPointcutAdvisor();
//        defaultPointAdvisor.setPointcut(druidStatPointcut);
//        defaultPointAdvisor.setAdvice(druidStatInterceptor);
//        return defaultPointAdvisor;
//    }
//    /* spring监控结束 */
//
//}
//
