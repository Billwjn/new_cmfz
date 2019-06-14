package com.baizhi.service;

import java.util.Map;

public interface UserService {
    Map<String,Object> queryUsers(Integer page , Integer rows);
}
