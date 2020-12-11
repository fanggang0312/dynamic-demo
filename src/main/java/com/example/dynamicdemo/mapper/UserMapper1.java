package com.example.dynamicdemo.mapper;

import com.example.dynamicdemo.config.annotations.DS;
import com.example.dynamicdemo.config.constants.DataSourceConstants;

/**
 * @Author: fanggang
 * @Date: 2020/12/11
 */
@DS(DataSourceConstants.DS_KEY_SLAVE)
public interface UserMapper1 {

    int getUserId(String name);

}
