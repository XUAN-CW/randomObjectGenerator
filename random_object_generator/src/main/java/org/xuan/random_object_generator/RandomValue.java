package org.xuan.random_object_generator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author XUAN-CW
 * @date 2021/7/16 - 23:28
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface RandomValue {
    String regex();
    int relevance() default 0;
}