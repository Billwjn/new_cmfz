package com.baizhi.dao;

import com.baizhi.entity.Chapter;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ChapterDao extends BaseDao<Chapter> {
    void updateDownPath(Chapter chapter);
    Integer selectRecords(String albumId);
    List<Chapter> selectAll(@Param("begin") Integer begin , @Param("rows") Integer rows , @Param("albumId") String albumId);
}
