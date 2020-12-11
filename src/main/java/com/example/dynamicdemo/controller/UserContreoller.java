package com.example.dynamicdemo.controller;

import com.example.dynamicdemo.service.UserService;
import com.example.dynamicdemo.service.UserService1;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: fanggang
 * @Date: 2020/12/11
 */
@Slf4j
@RestController
@RequestMapping("/user")
public class UserContreoller {

    @Autowired
    private UserService userService;
    @Autowired
    private UserService1 userService1;

    @GetMapping("/{name}")
    public  String getUserId(@PathVariable(name="name") String name){

        int id = userService.getUserId(name);

        int id1= userService1.getUserId(name);

        return "用户"+name+"在master库的id为："+id+",在slave库的id为："+id1;
    }

}
