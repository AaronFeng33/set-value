package com.field.setvalue.aspect;

import com.field.setvalue.utils.BeanUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 切面方法
 *
 * @author FengChuan
 * @since 2020-08-19 16:28:33
 */
@Aspect
@Component
public class SetFieldValueAspect {

    @Resource
    private BeanUtil beanUtil;

    /**
     * 为所有标记了@MethodNeedSetValue的方法执行切面方法
     *
     * @author FengChuan
     * @since 2020-08-19 22:09:07
     */
    @Around("@annotation(com.field.setvalue.annotation.MethodNeedSetValue)")
    public Object doSetValue(ProceedingJoinPoint pjp) throws Throwable {
        Object ret = pjp.proceed();
        beanUtil.judgeType(ret);
        return ret;
    }

}
