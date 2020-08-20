package com.field.setvalue.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 字段填充  - 标记需要执行字段填充的方法
 * 
 * @author FengChuan
 * @since 2020-08-19 20:21:46
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MethodNeedSetValue {
}
