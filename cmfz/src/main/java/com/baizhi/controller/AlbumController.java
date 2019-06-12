package com.baizhi.controller;

import com.baizhi.entity.Album;
import com.baizhi.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/album")
public class AlbumController {
    @Autowired
    private AlbumService albumService;
    @RequestMapping("/queryAll")
    public Map<String , Object> queryAll(Integer page , Integer rows){
        Map<String, Object> map = albumService.queryAll(page, rows);
        System.out.println(map);
        return map;
    }
    @RequestMapping("/edit")
    public String edit(Album album , String oper , String[] id){
        if ("edit".equals(oper)){
            if (album.getCover().equals("")){
                album.setCover(null);
            }
            albumService.modifyAlbum(album);
        }else if("add".equals(oper)){
            String s = albumService.addAlbum(album);
            return s;
        }else{
            for (String s : id) {
                albumService.removeAlbum(s);
            }
        }
        return "hello";
    }
    @RequestMapping("/upload")
    public void upload(String id , MultipartFile cover , HttpSession session){
        String originalFilename = cover.getOriginalFilename();
        String realPath = session.getServletContext().getRealPath("upload");
        File file = new File(realPath);
        if (!file.exists()){
            file.mkdir();
        }
        try {
            cover.transferTo(new File(realPath+"/"+originalFilename));
            Album album = new Album();
            album.setId(id);
            album.setCover(originalFilename);
            albumService.modifyCover(album);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    @RequestMapping("/queryAlbums")
    public void queryAlbums(HttpServletResponse response) throws IOException {
        List<Album> albums = albumService.queryAlbums();
        StringBuilder sb = new StringBuilder();
        sb.append("<select name='albumId'>");
        for (Album album : albums) {
            sb.append("<option value='"+album.getId()+"'>"+album.getTitle()+"</option>");
        }
        sb.append("</select>");
        String s = sb.toString();
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(s);
    }
}
