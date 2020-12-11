package com.example.dynamicdemo.config.aspect;

import com.example.dynamicdemo.config.annotations.DS;
import com.example.dynamicdemo.config.dynamic.DynamicDataSourceContextHolder;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * @Author: fanggang
 * @Date: 2020/12/11
 */
@Aspect
@Component
public class DynamicDataSourceAspect {

    @Pointcut("@within(com.example.dynamicdemo.config.annotations.DS)")
    public void dataSourcePointCut() {

    }

    @Around("dataSourcePointCut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        String dsKey = this.getDSAnnotation(joinPoint).value();
        DynamicDataSourceContextHolder.setContextKey(dsKey);
        try {
            return joinPoint.proceed();
        } catch (Exception ex) {
            throw ex;
        } finally {
            DynamicDataSourceContextHolder.removeContextKey();
        }
    }

    private DS getDSAnnotation(ProceedingJoinPoint joinPoint) {

        Class<?> aClass = joinPoint.getTarget().getClass().getInterfaces()[0];
        DS dsAnnotation = aClass.getAnnotation(DS.class);
        if (Objects.nonNull(dsAnnotation)) {

            return dsAnnotation;
        } else {
            MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
            DS annotation = methodSignature.getMethod().getAnnotation(DS.class);
            return annotation;
        }
    }

}
