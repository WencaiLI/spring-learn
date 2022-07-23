package com.lwc.springbootdozer.utils;

import org.dozer.Mapper;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * @Auther: liwencai
 * @Date: 2022/7/23 21:15
 * @Description:
 */
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