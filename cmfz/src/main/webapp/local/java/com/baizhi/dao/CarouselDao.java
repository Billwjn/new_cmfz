package com.baizhi.dao;

import java.util.List;

import com.baizhi.entity.Carousel;
import org.apache.ibatis.annotations.Param;

public interface CarouselDao {
	List<Carousel> selectCarousels(@Param("begin") Integer begin, @Param("rows") Integer rows);
	void insertCarousel(Carousel carousel);
	void updateCarousel(Carousel carousel);
	void deleteCarousel(@Param("id") String id);
	void updateCarouselImgPath(@Param("id") String id, @Param("imgPath") String imgPath);
	Integer selectRecords();
}
