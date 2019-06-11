package com.baizhi.dao;

import com.baizhi.entity.Carousel;

import java.util.List;

public interface BaseDao<T> {
    List<T> selectAll(Integer begin , Integer rows);
    void insert(T t);
    Integer selectRecords();
    void update(T t);
    void delete(String id);
}
