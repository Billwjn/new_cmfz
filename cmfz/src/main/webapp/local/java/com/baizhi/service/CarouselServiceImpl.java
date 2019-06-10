package com.baizhi.service;

import com.baizhi.dao.CarouselDao;
import com.baizhi.entity.Carousel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
@Transactional
public class CarouselServiceImpl implements CarouselService {
    @Autowired
    private CarouselDao carouselDao;
    @Override
    public Map<String ,Object> queryAll(Integer page, Integer rows) {
        Map<String , Object> map= new HashMap<>();
        Integer begin = (page-1)*rows;
        List<Carousel> carousels = carouselDao.selectCarousels(begin, rows);
        Integer integer = carouselDao.selectRecords();
        Integer total = 0;
        if (integer%rows == 0){
            total = integer/rows;
        }else{
            total = integer/rows+1;
        }
        map.put("page",page);
        map.put("total",total);
        map.put("records",integer);
        map.put("rows",carousels);
        return map;
    }

    @Override
    public String addCarousel(Carousel carousel) {
        String s = UUID.randomUUID().toString();
        carousel.setId(s);
        carouselDao.insertCarousel(carousel);
        return s;
    }

    @Override
    public void upload(String id, MultipartFile imgPath, HttpSession session) {
        String filename = imgPath.getOriginalFilename();
        String upload = session.getServletContext().getRealPath("upload");
        File file = new File(upload);
        if (!file.exists()){
            file.mkdir();
        }
        try {
            imgPath.transferTo(new File(upload,filename));
            carouselDao.updateCarouselImgPath(id,filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteCarousel(String[] id) {
        for (String s : id) {
            carouselDao.deleteCarousel(s);
        }
    }

    @Override
    public void modifyCarousel(Carousel carousel) {
        carouselDao.updateCarousel(carousel);
    }
}
