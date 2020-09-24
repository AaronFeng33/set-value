package com.field.setvalue.utils;

import com.field.setvalue.annotation.FieldNeedSetValue;
import com.field.setvalue.annotation.ResultListName;
import com.field.setvalue.model.PageVO;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 字段填充工具
 *
 * @author FengChuan
 * @since 2020-08-19 16:25:02
 */
@Component
public class BeanUtil implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public void judgeType(Object obj) throws Exception {
        if (obj instanceof Collection) {
            // 集合
            setField((Collection<?>) obj);
        } else if (obj instanceof PageVO){
            // 分页对象
            PageVO<?> pageVO = (PageVO<?>)obj;
            setField(pageVO.getList());
        }else {
            // VO对象
            ResultListName annotation = obj.getClass().getAnnotation(ResultListName.class);
            String listName = annotation == null ? "list" : annotation.collectionName();
            List<?> list = (List<?>) obj.getClass().getDeclaredField(listName).get(obj);
            setField(list);
        }
    }


    public void setField(Collection<?> col) throws Exception {
        // 获取 返回结果集合里存放的VO
        Class<?> voClass = col.iterator().next().getClass();
        // 获取该VO的属性
        Field[] fields = voClass.getDeclaredFields();
        // 缓存
        Map<String, Object> cache = new HashMap<>(16);
        // 循环判断该VO的属性带不带@NeedSetValue注解
        for (Field field : fields) {
            FieldNeedSetValue annotation = field.getAnnotation(FieldNeedSetValue.class);
            if (annotation == null) {
                continue;
            }
            
            field.setAccessible(true);
            // 获取执行该方法的类
            Object bean = this.applicationContext.getBean(annotation.beanClass());
            // 获取该方法
            Method method = annotation.beanClass().getMethod(annotation.method(), voClass.getDeclaredField(annotation.param()).getType());
            // 获取传参
            Field param = voClass.getDeclaredField(annotation.param());
            param.setAccessible(true);

            String keyPrefix = annotation.beanClass() + "-" + annotation.method() + "-" + annotation.targetField() + "-";

            for (Object obj : col) {
                // 获取执行参数
                Object paramValue = param.get(obj);
                if (paramValue == null) {
                    continue;
                }

                // 调用的方法执行后的返回值
                Object value;
                String key = keyPrefix + paramValue;
                if (cache.containsKey(key)) {
                    value = cache.get(key);
                } else {
                    value = method.invoke(bean,paramValue);
                    // 判断方法执行后的返回值不为空
                    if (value != null) {
                        Field targetField = value.getClass().getDeclaredField(annotation.targetField());
                        targetField.setAccessible(true);
                        value = targetField.get(value);
                        cache.put(key, value);
                    }
                }
                field.set(obj, value);
            }
        }
    }
}
