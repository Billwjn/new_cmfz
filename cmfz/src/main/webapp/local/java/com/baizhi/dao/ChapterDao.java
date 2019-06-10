package com.baizhi.dao;

import com.baizhi.entity.Chapter;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ChapterDao {
    List<Chapter> selectByAlbumId(@Param("albumId") String albumId);
    //添加方法
    void insertChapter(Chapter chapter);
    //根据id修改下载路径
    void updatePath(@Param("id") String id, @Param("downPath") String downPath);
    //删除章节
    void deleteChapter(@Param("id") String id);
}
