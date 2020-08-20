package com.field.setvalue.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 标记返回结果中需要填充的集合的名字
 *
 * @author FengChuan
 * @since 2020-08-20 10:39:04
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface ResultListName {
    /**
     * 返回结果中需要填充的集合的名字
     */
    String collectionName();
}
