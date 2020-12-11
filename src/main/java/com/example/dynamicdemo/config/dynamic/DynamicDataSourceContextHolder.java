package com.example.dynamicdemo.config.dynamic;

import com.example.dynamicdemo.config.constants.DataSourceConstants;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author: fanggang
 * @Date: 2020/12/11
 */
@Slf4j
public class DynamicDataSourceContextHolder {

    private static final ThreadLocal<String> DATASOURCE_CONTEXT_KEY_HOLDER = new ThreadLocal<>();

    public static void setContextKey(String key) {
        log.info("切换数据源为：" + key);
        DATASOURCE_CONTEXT_KEY_HOLDER.set(key);
    }

    public static String getContextKey() {
        String key = DATASOURCE_CONTEXT_KEY_HOLDER.get();
        return key == null ? DataSourceConstants.DS_KEY_MASTER : key;
    }

    public static void removeContextKey() {
        DATASOURCE_CONTEXT_KEY_HOLDER.remove();
    }

}
