package com.baizhi.controller;

import com.baizhi.entity.Album;
import com.baizhi.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.util.Map;

@RestController
@RequestMapping("album")
public class AlbumController {
    @Autowired
    private AlbumService albumService;
    @RequestMapping("queryAll")
    public Map<String , Object> queryAll(Integer page , Integer rows){
        Map<String, Object> stringObjectMap = albumService.queryAll(page, rows);
        return stringObjectMap;
    }
    @RequestMapping("edit")
    public String edit(Album album,String oper,String[] id){
        String s = null;
        if ("edit".equals(oper)){
            albumService.modifyAlbum(album);
        }else if ("add".equals(oper)){
            s = albumService.addAlbum(album);
        }else if ("del".equals(oper)){
            albumService.removeAlbum(id);
        }
        return s;
    }
    @RequestMapping("upload")
    public void upload(String id , MultipartFile cover, HttpSession session){
        albumService.upload(id,  cover , session);
    }
}
