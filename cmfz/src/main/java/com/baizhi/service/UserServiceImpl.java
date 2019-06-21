package com.baizhi.service;

import com.baizhi.dao.UserDao;
import com.baizhi.entity.User;
import com.baizhi.entity.UserDTO;
import com.baizhi.util.MD5Utils;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import io.goeasy.GoEasy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Map<String, Object> queryUsers(Integer page, Integer rows) {
        Map<String,Object> map = new HashMap<>();
        Integer records = userDao.selectRecords();
        Integer begin = (page - 1)*rows;
        List<User> users = userDao.selectAll(begin, rows);
        Integer total = records % rows == 0 ? records / rows : records / rows + 1;
        map.put("total",total);
        map.put("rows",users);
        map.put("records",records);
        map.put("page",page);
        return map;
    }

    @Override
    public Map<String , Object> queryStatistics() {
        List<UserDTO> userStatistics = userDao.selectStatistics();
        Map<String , Object> map = new HashMap<>();
        List<String> months = new ArrayList<>();
        List<String> counts = new ArrayList<>();
        for (UserDTO userStatistic : userStatistics) {
            months.add(userStatistic.getMonths());
            counts.add(userStatistic.getCounts());
        }
        map.put("months",months);
        map.put("counts",counts);
        return map;
    }

    @Override
    public Map<String, Object> queryDistribution() {
        Map<String,Object> map = new HashMap<>();
        map.put("man" , userDao.selectDistributionOnMan());
        map.put("woman",userDao.selectDistributionOnWoman());
        return map;
    }

    @Override
    public List<User> queryAllUsers() {
        List<User> users = userDao.selectAllUsers();
        return users;
    }

    @Override
    public String regist(User user) {
        String id = UUID.randomUUID().toString();
        String salt = MD5Utils.getSalt();
        String secretPassword = MD5Utils.getPassword(user.getPassword());
        String status = "正常";
        user.setId(id);
        user.setSalt(salt);
        user.setPassword(secretPassword);
        user.setStatus(status);
        userDao.insert(user);
        return id;
    }
}
