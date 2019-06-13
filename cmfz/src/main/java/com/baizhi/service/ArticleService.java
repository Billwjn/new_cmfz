package com.baizhi.service;

import com.baizhi.entity.Article;
import com.baizhi.entity.Guru;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

public interface ArticleService {
    Map<String,Object> queryAll(Integer page , Integer rows);
    List<Guru> queryGurus();
    String addArticle(Article article , MultipartFile imgFile , HttpSession session);
    Article queryOneArticle(String id);
}
