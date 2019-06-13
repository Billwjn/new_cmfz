package com.baizhi.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.*;

@RestController
@RequestMapping("/kindeditor")
public class KindeditorController {
    @RequestMapping("/upload")
    public Map<String , Object> upload(MultipartFile file, HttpSession session){
        String realPath = session.getServletContext().getRealPath("upload");
        String originalFilename = file.getOriginalFilename();
        Map<String , Object> map = new HashMap<>();
        File file1 = new File(realPath);
        if (!file1.exists()){
            file1.mkdir();
        }
        try {
            file.transferTo(new File(realPath+"/"+originalFilename));
            map.put("error",0);
            map.put("url","http://localhost:9999/cmfz/upload/"+originalFilename);
        } catch (IOException e) {
            map.put("error",1);
            map.put("url","http://localhost:9999/cmfz/upload/"+originalFilename);
            e.printStackTrace();
        }
        return map;
    }
    @RequestMapping("show")
    public Map<String, Object> show(HttpSession session){
        Map<String , Object> map = new HashMap<>();
        String realPath = session.getServletContext().getRealPath("upload");
        map.put("current_url","http://localhost:9999/cmfz/upload/");
        File file = new File(realPath);
        String[] list = file.list();
        map.put("total_count",list.length);
        List pictures = new ArrayList();
        for (int i = 0; i < list.length; i++) {
            Map<String,Object> map1 = new HashMap<>();
            map1.put("is_dir",false);
            map1.put("has_file",false);
            String s = list[i];
            File imgFile = new File(realPath + "/" + s);
            map1.put("filesize",imgFile.length());
            map1.put("is_photo",true);
            String substring = s.substring(s.lastIndexOf(".")+1);
            map1.put("filetype",substring);
            map1.put("filename",s);
            map1.put("datetime",new Date());
            pictures.add(map1);
        }
        map.put("file_list",pictures);
        return map;
    }
}
