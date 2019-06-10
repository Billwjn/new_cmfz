package com.baizhi.service;

import com.baizhi.entity.Album;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.util.Map;

public interface AlbumService {
    Map<String , Object> queryAll(Integer page , Integer rows);
    String addAlbum(Album album);
    void upload(String id , MultipartFile cover , HttpSession session);
    void removeAlbum(String[] id);
    void modifyAlbum(Album album);
}
