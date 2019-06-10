package com.baizhi.service;

import com.baizhi.entity.Carousel;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

public interface CarouselService {
    //分页查询所有
    Map<String , Object> queryAll(Integer page , Integer rows);
    //添加方法
    String addCarousel(Carousel carousel);
    //上传图片并且修改图片路径
    void upload(String id , MultipartFile imgPath , HttpSession session);
    //删除方法
    void deleteCarousel(String[] id);
    //修改方法
    void modifyCarousel(Carousel carousel);
}
