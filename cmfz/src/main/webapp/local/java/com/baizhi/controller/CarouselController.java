package com.baizhi.controller;

import com.baizhi.entity.Carousel;
import com.baizhi.service.CarouselService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.util.Map;

@RestController
@RequestMapping("carousel")
public class CarouselController {
    @Autowired
    private CarouselService carouselService;
    @RequestMapping("queryAll")
    public Map<String , Object> queryAll(Integer page , Integer rows){
        Map<String, Object> stringObjectMap = carouselService.queryAll(page, rows);
        return stringObjectMap;
    }
    @RequestMapping("edit")
    public String edit(Carousel carousel , String oper , String[] id){
        String s = null;
        if ("edit".equals(oper)){
            carouselService.modifyCarousel(carousel);
        }else if ("add".equals(oper)){
            s = carouselService.addCarousel(carousel);
        }else if ("del".equals(oper)){
            carouselService.deleteCarousel(id);
        }
        return s;
    }
    @RequestMapping("upload")
    public void upload(String id , MultipartFile imgPath , HttpSession session){
        carouselService.upload(id,imgPath,session);
    }

}
