package com.example.dynamicdemo.config.annotations;

import com.example.dynamicdemo.config.constants.DataSourceConstants;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author: fanggang
 * @Date: 2020/12/11
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface DS {

    String value() default DataSourceConstants.DS_KEY_MASTER;

}
