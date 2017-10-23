package org.jamesblog.article.service;

import org.jamesblog.article.mapper.ArticleMapper;
import org.jamesblog.article.model.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * Created by jamescsh on 10/15/17.
 */
@Service
public class ArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    /**
     * 获取文章列表
     */
    public List<Article> getArticles() {
        return articleMapper.selectAll();
    }

    /**
     * 查询获取文章
     * @param id    文章ID
     */
    public Article getArticleById(Long id) {
        return articleMapper.selectByPrimaryKey(id);
    }
}
