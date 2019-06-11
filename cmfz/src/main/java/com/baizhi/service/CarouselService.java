package com.baizhi.service;

import com.baizhi.entity.Carousel;

import java.util.List;
import java.util.Map;

public interface CarouselService {
    Map<String , Object> queryAll(Integer rows , Integer page);
    String addCarousel(Carousel carousel);
    void modifyCarousel(Carousel carousel);
    void modifyImgpath(Carousel carousel);
    void removeCarousel(String id);
}
