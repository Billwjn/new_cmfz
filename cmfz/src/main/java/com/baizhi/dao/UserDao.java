package com.baizhi.dao;

import com.baizhi.entity.User;
import com.baizhi.entity.UserDTO;

import java.util.List;

public interface UserDao extends BaseDao<User> {
    List<UserDTO> selectStatistics();
    List<UserDTO> selectDistributionOnMan();
    List<UserDTO> selectDistributionOnWoman();
    List<User> selectAllUsers();
}
