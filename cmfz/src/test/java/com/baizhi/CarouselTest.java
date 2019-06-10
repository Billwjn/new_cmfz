package com.baizhi;

import com.baizhi.entity.Carousel;
import com.baizhi.service.CarouselService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CarouselTest {
    @Autowired
    private CarouselService carouselService;
    @Test
    public void testAdd(){
        carouselService.addCarousel(new Carousel(null , "第一个轮播图","imgPath","描述1","on",null));
    }
    @Test
    public void testQuery(){
        Map<String, Object> stringObjectMap = carouselService.queryAll(3, 1);
        for (String s : stringObjectMap.keySet()) {
            System.out.println(stringObjectMap.get(s));
        }
    }
    @Test
    public void testModify(){
        Carousel carousel = new Carousel("1", "1", "2", "1", "off", new Date());
        carouselService.modifyCarousel(carousel);
    }
}
