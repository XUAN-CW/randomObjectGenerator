package org.xuan.random_object_generator;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author XUAN-CW
 * @date 2021/7/16 - 23:39
 */
public class RandomObjectGenerator {



    public static <T> T generate(Class<T> clazz) throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        // 实例化
        T randomObject=clazz.getDeclaredConstructor().newInstance();
        //遍历所有字段
        for (Field field : clazz.getDeclaredFields()) {
            //获取各个字段的 set 方法
            String fieldSetterName = "set" + field.getName().substring(0,1).toUpperCase()+field.getName().substring(1);
            Method fieldSetterMethod =  clazz.getDeclaredMethod(fieldSetterName,field.getType());
            //获取字段上的 @RandomValue 注解
            RandomValue annotation = field.getAnnotation(RandomValue.class);
            // 注解不为空，则注入
            if(null != annotation){
                fieldSetterMethod.invoke(randomObject, annotation.regex());
            }
        }

        return randomObject;
    }
}
