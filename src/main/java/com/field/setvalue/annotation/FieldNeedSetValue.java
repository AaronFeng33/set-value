package com.field.setvalue.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 字段填充 - 标记需要填充的字段
 *
 * @author FengChuan
 * @since 2020-08-19 16:27:03
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface FieldNeedSetValue {

    /**
     * 需要调用的方法所在类
     */
    Class<?> beanClass();

    /**
     * 方法的传参，可以是数组
     */
    String param();

    /**
     * 需要调用的方法
     */
    String method();

    /**
     * 调用方法后，需要从返回值取得的字段
     */
    String targetField();
}
