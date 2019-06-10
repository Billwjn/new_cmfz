package com.baizhi.dao;

import com.baizhi.entity.Album;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AlbumDao {
    List<Album> selectAll(@Param("begin") Integer begin, @Param("rows") Integer rows);
    void insertAlbum(Album album);
    //查询总条数
    Integer selectCount();
    //修改文件路径
    void updateUrl(@Param("id") String id, @Param("cover") String cover);
    //通过id删除专辑
    void deleteAlbum(@Param("id") String id);
    //修改专辑
    void updateAlbum(Album album);
}
