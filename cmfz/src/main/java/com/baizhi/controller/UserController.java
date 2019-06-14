package com.baizhi.controller;

import com.baizhi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("queryAll")
    public Map<String,Object> queryAll(Integer page , Integer rows){
        Map<String, Object> stringObjectMap = userService.queryUsers(page, rows);
        return stringObjectMap;
    }
}
