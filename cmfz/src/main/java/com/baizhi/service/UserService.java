package com.baizhi.service;

import com.baizhi.entity.User;

import java.util.List;
import java.util.Map;

public interface UserService {
    Map<String,Object> queryUsers(Integer page , Integer rows);
    Map<String,Object> queryStatistics();
    Map<String,Object> queryDistribution();
    List<User> queryAllUsers();
    String regist(User user);
}
