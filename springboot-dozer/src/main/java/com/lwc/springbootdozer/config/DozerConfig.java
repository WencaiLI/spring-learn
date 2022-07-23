package com.lwc.springbootdozer.config;

import com.lwc.springbootdozer.utils.BeanMapper;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

/**
 * @Auther: liwencai
 * @Date: 2022/7/23 21:14
 * @Description:
 */
@Configuration
public class DozerConfig {
    @Bean
    public DozerBeanMapper dozer(){
        List<String> mappingFiles = Arrays.asList("dozer/dozer-mapping.xml");
        DozerBeanMapper dozerBean = new DozerBeanMapper();
        dozerBean.setMappingFiles(mappingFiles);
        return dozerBean;
    }
    @Bean
    public BeanMapper beanMapper(Mapper dozer){
        return new BeanMapper(dozer);
    }
}
