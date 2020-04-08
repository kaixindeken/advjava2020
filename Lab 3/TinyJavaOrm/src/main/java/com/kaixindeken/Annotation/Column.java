package com.kaixindeken.Annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Column {
    //字段名
    String value();
    //字段类型
    Class<?> type() default String.class;
    //字段长度
    int length() default 0;
}
