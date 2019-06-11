package com.baizhi.controller;

import com.baizhi.entity.Carousel;
import com.baizhi.service.CarouselService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.Map;

@RestController
@RequestMapping("/carousel")
public class CarouselController {
    @Autowired
    private CarouselService carouselService;
    @RequestMapping("/queryAll")
    public Map<String , Object> queryAll(Integer rows , Integer page){
        Map<String, Object> stringObjectMap = carouselService.queryAll(rows, page);
        return stringObjectMap;
    }
    @RequestMapping("/edit")
    public String edit(Carousel carousel , String oper , String[] id){
        if (oper.equals("add")){
            System.out.println("添加轮播图到数据库");
            String carouselId = carouselService.addCarousel(carousel);
            return carouselId;
        }else if (oper.equals("edit")){
            System.out.println("修改轮播图");
            if (carousel.getImgPath() .equals("")){
                carousel.setImgPath(null);
            }
            carouselService.modifyCarousel(carousel);
        }else{
            for (String s : id) {
                carouselService.removeCarousel(s);
            }
        }
        return null;
    }
    @RequestMapping("/upload")
    public void upload(String id , MultipartFile imgPath, HttpServletRequest request , HttpServletResponse response){
        System.out.println("上传文件，并将数据库中的文件路径修改为上传的文件名");
        String name = imgPath.getOriginalFilename();
        String realPath = request.getSession().getServletContext().getRealPath("upload");
        File file = new File(realPath);
        if (!file.exists()){
            file.mkdir();
        }
        try {
            imgPath.transferTo(new File(realPath+"/"+name));
            Carousel carousel = new Carousel();
            carousel.setId(id);
            carousel.setImgPath(name);
            carouselService.modifyImgpath(carousel);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
