## 1、引入依赖

```xml
        <!-- dozer依赖 -->
        <dependency>
            <groupId>net.sf.dozer</groupId>
            <artifactId>dozer</artifactId>
            <version>5.5.1</version>
        </dependency>
```

## 2、配置映射文件

在resources目录下创dozer映射文件夹，创建dozer-mapping.xml文件。

```xml
<?xml version="1.0" encoding="UTF-8"?>
<mappings xmlns="http://dozer.sourceforge.net" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
          xsi:schemaLocation="http://dozer.sourceforge.net
          http://dozer.sourceforge.net/schema/beanmapping.xsd">
    <!-- 类与类之间的转换关系，定义后，两个类可使用BeanMapper进行转换例 -->
</mappings>
```

## 3、xml指示用户配置文件

```xml
<mapping>

    <class-a>yourpackage.yourSourceClassName</class-a>

    <class-b>yourpackage.yourDestinationClassName</class-b>

    <field>

    <a>yourSourceFieldName</a>

    <b>yourDestinationFieldName</b>

    </field>

</mapping>
```

常用的还有`<configuration>`

```xml
<?xml version="1.0"encoding="UTF-8"?>

<mappings xmlns="http://dozer.sourceforge.net"

     xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"

    xsi:schemaLocation="http://dozer.sourceforge.net

                    http://dozer.sourceforge.net/schema/beanmapping.xsd">

    <configuration>

        <stop-on-errors>true</stop-on-errors>

        <date-format>yyyy-MM-dd HH:mm:ss</date-format>

        <wildcard>true</wildcard>

    </configuration>

    <mapping>

        <class-a>yourpackage.yourSourceClassName</class-a>

        <class-b>yourpackage.yourDestinationClassName</class-b>

    <field>

        <A>yourSourceFieldName</A>

        <B>yourDestinationFieldName</B>

    </field>

    </mapping>

othercustom class mappings would go here.......

</mappings>
```

## 4、config文件

```java
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tcu.example.springboot.utils.BeanMapper;
import java.util.Arrays;
import java.util.List;

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
```

## 5、工具类

```java
package com.xkl.authdemo.utils;

import org.dozer.Mapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class BeanMapper {
    private Mapper dozer;

    public BeanMapper(Mapper dozer){this.dozer = dozer;}

    public <T> T map(Object source,Class<T> destinationClass){
        return source == null ? null :this.dozer.map(source,destinationClass);
    }

    public <T> List<T> mapList(Collection sourceList, Class<T> destinationClass){
        ArrayList destinationList = new ArrayList();
        if(sourceList == null){
            return destinationList;
        }else{
            Iterator i$ = sourceList.iterator();
            while(i$.hasNext()){
                Object sourceObj = i$.next();
                Object destinationObj = this.dozer.map(sourceObj,destinationClass);
                destinationList.add(destinationObj);
            }
            return destinationList;
        }
    }
    public void copy(Object source,Object destinationObject){
        this.dozer.map(source,destinationObject);
    }
}
```

## 6、使用

```java
@Autowired
    BeanMapper beanMapper;
```

```java
// 需要在dozer-mapper.xml中按指定方式添加映射规则
List<User> userList = userSpecMapper.selectAll();
        return beanMapper.mapList(userList,UserDTO.class);

User user = userSpecMapper.selectById(id);
        return beanMapper.map(user,UserDTO.class);
```



