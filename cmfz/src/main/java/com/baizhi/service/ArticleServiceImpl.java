package com.baizhi.service;

import com.baizhi.dao.ArticleDao;
import com.baizhi.entity.Article;
import com.baizhi.entity.Carousel;
import com.baizhi.entity.Guru;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
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
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleDao articleDao;
    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Map<String, Object> queryAll(Integer page, Integer rows) {
        Integer records = articleDao.selectRecords();
        Integer begin = (page - 1)*rows;
        Integer total = records % rows == 0 ? records / rows : records / rows + 1;
        List<Article> articles = articleDao.selectAll(begin , rows);
        Map<String , Object> map = new HashMap<>();
        map.put("records" , records);
        map.put("total" , total);
        map.put("page" , page);
        map.put("rows" , articles);
        return map;
    }

    @Override
    public List<Guru> queryGurus() {
        List<Guru> gurus = articleDao.selectGurus();
        return gurus;
    }

    @Override
    public String addArticle(Article article, MultipartFile imgFile, HttpSession session) {
        String s = UUID.randomUUID().toString();
        article.setId(s);
        String realPath = session.getServletContext().getRealPath("upload");
        String originalFilename = imgFile.getOriginalFilename();
        File file = new File(realPath);
        if (!file.exists()){
            file.mkdir();
        }
        try {
            imgFile.transferTo(new File(realPath+"/"+originalFilename));
            article.setImgPath(originalFilename);
            articleDao.insert(article);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return s;
    }

    @Override
    public Article queryOneArticle(String id) {
        Article article = articleDao.selectOneArticle(id);
        return article;
    }
}
