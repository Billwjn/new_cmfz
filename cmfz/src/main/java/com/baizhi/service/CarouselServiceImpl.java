package com.baizhi.service;

import com.baizhi.annotation.RedisCacheAnnotation;
import com.baizhi.dao.CarouselDao;
import com.baizhi.entity.Carousel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional
public class CarouselServiceImpl implements CarouselService {
    @Autowired
    private CarouselDao carouselDao;
    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    @RedisCacheAnnotation
    public Map<String , Object> queryAll(Integer rows , Integer page) {
        Integer records = carouselDao.selectRecords();
        Integer begin = (page - 1)*rows;
        Integer total = records % rows == 0 ? records / rows : records / rows + 1;
        List<Carousel> carousels = carouselDao.selectAll(begin , rows);
        Map<String , Object> map = new HashMap<>();
        map.put("records" , records);
        map.put("total" , total);
        map.put("page" , page);
        map.put("rows" , carousels);
        return map;
    }

    @Override
    public String addCarousel(Carousel carousel) {
        String id = UUID.randomUUID().toString();
        carousel.setId(id);
        carouselDao.insert(carousel);
        return id;
    }

    @Override
    public void modifyCarousel(Carousel carousel) {
        carouselDao.update(carousel);
    }

    @Override
    public void modifyImgpath(Carousel carousel) {
        carouselDao.updateImgpath(carousel);
    }

    @Override
    public void removeCarousel(String id) {
        carouselDao.delete(id);
    }
}
