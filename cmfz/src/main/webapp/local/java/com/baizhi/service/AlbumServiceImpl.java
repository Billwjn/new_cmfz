package com.baizhi.service;

import com.baizhi.dao.AlbumDao;
import com.baizhi.entity.Album;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
@Transactional
public class AlbumServiceImpl implements AlbumService {
    @Autowired
    private AlbumDao albumDao;
    @Override
    public Map<String, Object> queryAll(Integer page, Integer rows) {
        Integer begin = (page-1)*rows;
        List<Album> albums = albumDao.selectAll(begin, rows);
        Map<String ,Object> map = new HashMap<>();
        Integer records = albumDao.selectCount();
        Integer total = 0;
        if (records%rows == 0){
            total = records/rows;
        }else{
            total = records/rows +1;
        }
        map.put("rows",albums);
        map.put("page",page);
        map.put("records",records);
        map.put("total",total);
        return map;
    }

    @Override
    public String addAlbum(Album album) {
        String s = UUID.randomUUID().toString();
        album.setId(s);
        albumDao.insertAlbum(album);
        return s;
    }

    @Override
    public void upload(String id, MultipartFile cover, HttpSession session) {
        String filename = cover.getOriginalFilename();
        String upload = session.getServletContext().getRealPath("upload");
        File file = new File(upload);
        if (!file.exists()) {
            file.mkdir();
        }
        try {
            cover.transferTo(new File(upload,filename));
            albumDao.updateUrl(id , filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeAlbum(String[] id) {
        for (String s : id) {
            albumDao.deleteAlbum(s);
        }
    }

    @Override
    public void modifyAlbum(Album album) {
        albumDao.updateAlbum(album);
    }
}
