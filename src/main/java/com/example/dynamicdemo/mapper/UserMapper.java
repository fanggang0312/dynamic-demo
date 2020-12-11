package com.example.dynamicdemo.mapper;

import com.example.dynamicdemo.config.annotations.DS;
import com.example.dynamicdemo.config.constants.DataSourceConstants;
import org.apache.ibatis.annotations.Param;

/**
 * @Author: fanggang
 * @Date: 2020/12/11
 */
@DS(DataSourceConstants.DS_KEY_MASTER)
public interface UserMapper {

    int getUserId(@Param("name") String name);

}
