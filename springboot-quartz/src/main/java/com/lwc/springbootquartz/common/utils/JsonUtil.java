package com.lwc.springbootquartz.common.utils;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.StringWriter;
import java.util.List;
import java.util.Map;

/**
 * @Author: liwencai
 * @Description: JSON 工具类
 * @Date: 2022/9/9
 * @Param null:
 * @return: null
 */
public class JsonUtil {
    public static  String toJsonForHuman(Object obj ){
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public static  String toJson(Object obj){
        StringWriter sw = new StringWriter();
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(sw, obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return sw.toString();
    }
    public static  String toJsonNotNull(Object obj){
        StringWriter sw = new StringWriter();
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
            mapper.writeValue(sw, obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return sw.toString();
    }

    public static <T> T fromJson (Class<T> klass,String jsonStr) {
        ObjectMapper mapper = new ObjectMapper();
        T obj = null;
        try {
            obj = mapper.readValue(jsonStr, klass);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return obj;
    }
    public static <T> List<T> fromJsonAsList(Class<T> klass,String jsonStr){
        ObjectMapper mapper = new ObjectMapper();
        List<T> objList = null;
        try {
            JavaType t = mapper.getTypeFactory().constructParametricType(
                    List.class, klass);
            objList = mapper.readValue(jsonStr, t);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return objList;
    }

    /**
     * 判断给定的字符串是否是json格式
     * @param jsonStr
     * @return
     */
    public static boolean isJson(String jsonStr) {
        try {
            if (jsonStr.startsWith("{")) {
                fromJson(Map.class, jsonStr);
            } else {
                fromJsonAsList(Map.class, jsonStr);
            }
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
