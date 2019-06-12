package com.baizhi.controller;

import com.baizhi.entity.Chapter;
import com.baizhi.service.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Map;

@RestController
@RequestMapping("/chapter")
public class ChapterController {
    @Autowired
    private ChapterService chapterService;
    @RequestMapping("/queryAll")
    public Map<String , Object> queryAll(Integer page , Integer rows , String albumId){
        System.out.println(page);
        System.out.println(rows);
        System.out.println(albumId);
        Map<String, Object> stringObjectMap = chapterService.queryAll(page, rows , albumId);
        return stringObjectMap;
    }
    @RequestMapping("/edit")
    public String edit(Chapter chapter , String oper , String[] id){
        if ("edit".equals(oper)){
            chapterService.modifyChapter(chapter);
        }else if("add".equals(oper)){
            String s = chapterService.addChapter(chapter);
            return s;
        }else{
            for (String s : id) {
                chapterService.removeChapter(s);
            }
        }
        return null;
    }
    @RequestMapping("/upload")
    public void upload(String id , MultipartFile downPath , HttpSession session){
        String originalFilename = downPath.getOriginalFilename();
        String realPath = session.getServletContext().getRealPath("music");
        File file = new File(realPath);
        if (!file.exists()){
            file.mkdir();
        }
        try {
            downPath.transferTo(new File(realPath+"/"+originalFilename));
            Chapter chapter = new Chapter();
            chapter.setId(id);
            chapter.setDownPath(originalFilename);
            chapterService.modifyDownPath(chapter);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
