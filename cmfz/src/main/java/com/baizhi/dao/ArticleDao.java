package com.baizhi.dao;

import com.baizhi.entity.Article;
import com.baizhi.entity.Guru;

import java.util.List;

public interface ArticleDao extends BaseDao<Article> {
    List<Guru> selectGurus();
    Article selectOneArticle(String id);
}
