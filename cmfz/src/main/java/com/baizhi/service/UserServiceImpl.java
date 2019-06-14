package com.baizhi.service;

import com.baizhi.dao.UserDao;
import com.baizhi.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
}
