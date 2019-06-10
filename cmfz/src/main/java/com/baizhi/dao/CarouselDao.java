package com.baizhi.dao;

import com.baizhi.entity.Carousel;

public interface CarouselDao extends BaseDao<Carousel> {
    void updateImgpath(Carousel carousel);
}
