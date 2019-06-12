package com.baizhi.service;

import com.baizhi.dao.AlbumDao;
import com.baizhi.entity.Album;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional
public class AlbumServiceImpl implements AlbumService{
    @Autowired
    private AlbumDao albumDao;
    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Map<String, Object> queryAll(Integer page , Integer rows) {
        Integer begin = (page - 1)*rows;
        Integer records = albumDao.selectRecords();
        Integer total = records % rows == 0 ? records / rows : records / rows + 1;
        List<Album> albums = albumDao.selectAll(begin, rows);
        Map<String , Object> map = new HashMap<>();
        map.put("page",page);
        map.put("rows",albums);
        map.put("records",records);
        map.put("total",total);
        return map;
    }

    @Override
    public String addAlbum(Album album) {
        String s = UUID.randomUUID().toString();
        album.setId(s);
        albumDao.insert(album);
        return s;
    }

    @Override
    public void modifyAlbum(Album album) {
        albumDao.update(album);
    }

    @Override
    public void modifyCover(Album album) {
        albumDao.updateCover(album);
    }

    @Override
    public void removeAlbum(String id) {
        albumDao.delete(id);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Album> queryAlbums() {
        List<Album> albums = albumDao.selectAlbums();
        return albums;
    }
}
