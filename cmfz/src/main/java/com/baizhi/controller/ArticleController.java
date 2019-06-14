package com.baizhi.controller;

import com.baizhi.entity.Article;
import com.baizhi.entity.Guru;
import com.baizhi.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import javax.xml.ws.RequestWrapper;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    private ArticleService articleService;
    @RequestMapping("/queryAll")
    public Map<String , Object> queryAll(Integer page , Integer rows){
        Map<String, Object> stringObjectMap = articleService.queryAll(page, rows);
        return stringObjectMap;
    }
    @RequestMapping("/queryGurus")
    public String queryGurus(){
        List<Guru> gurus = articleService.queryGurus();
        StringBuilder sb = new StringBuilder();
        for (Guru guru : gurus) {
            sb.append("<option value='"+guru.getId()+"'>"+guru.getName()+"</option>");
        }
        return sb.toString();
    }
    @RequestMapping("addArticle")
    public void addArticle(Article article , MultipartFile imgFile , HttpSession session){
        articleService.addArticle(article , imgFile , session);
    }
    @RequestMapping("queryOneArticle")
    public String queryOneArticle(String id){
        Article article = articleService.queryOneArticle(id);
        return article.getContent();
    }
    @RequestMapping("removeArticle")
    public void removeArticle(String id){
        articleService.removeArticle(id);
    }
}
