package com.lwc.springbootinfluxdb;

import org.influxdb.dto.QueryResult;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import plus.ojbk.influxdb.core.InfluxdbTemplate;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
class SpringbootInfluxdbApplicationTests {

    @Resource
    private InfluxdbTemplate influxdbTemplate;

    @Test
    void create() {
        Map<String, String> tags = new HashMap<>();
        tags.put("itemCode","CHWP_1");

        Map<String, Object> fields = new HashMap<>();

        fields.put("cop",132);
        fields.put("freq",123);

        Long time = LocalDateTime.now().toEpochSecond(ZoneOffset.of("+8"));
        String measurement = "xx";
        influxdbTemplate.insert(tags,fields,time,measurement);
    }

    // SELECT <field_key>[,<field_key>,<tag_key>] FROM <measurement_name>[,<measurement_name>]
    @Test
    void queryAllByTag(){
        String query = "select * from xx where itemCode = 'CHWP_1'";
        QueryResult execute = influxdbTemplate.execute(query);
        List<QueryResult.Result> results = execute.getResults();
        results.forEach(e->{
            e.getSeries().forEach(t->{
                System.out.println(t.getColumns());
                List<List<Object>> values = t.getValues();
                values.forEach(System.out::println);
            });
        });
    }

    @Test
    void update (){
        Map<String, String> tags = new HashMap<>();
        tags.put("itemCode","CHWP_1");

        Map<String, Object> fields = new HashMap<>();

        fields.put("cop",12);
        fields.put("freq",123);

        String start  = "2020-01-01 00:00:00";
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        Long time = LocalDateTime.from(dtf.parse(start)).toEpochSecond(ZoneOffset.of("+8"));
        String measurement = "xx";
        influxdbTemplate.insert(tags,fields,time,measurement);
    }

}
