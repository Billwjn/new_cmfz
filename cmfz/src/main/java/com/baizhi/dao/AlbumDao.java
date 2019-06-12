package com.baizhi.dao;

import com.baizhi.entity.Album;

import java.util.List;

public interface AlbumDao extends BaseDao<Album> {
    void updateCover(Album album);
    List<Album> selectAlbums();
    void updateCount(String albumId);
}
