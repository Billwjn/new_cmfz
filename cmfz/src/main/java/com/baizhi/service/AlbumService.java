package com.baizhi.service;

import com.baizhi.entity.Album;
import com.baizhi.entity.Carousel;

import java.util.List;
import java.util.Map;

public interface AlbumService {
    Map<String, Object> queryAll(Integer page , Integer rows);
    String addAlbum(Album album);
    void modifyAlbum(Album album);
    void modifyCover(Album album);
    void removeAlbum(String id);
    List<Album> queryAlbums();
}
