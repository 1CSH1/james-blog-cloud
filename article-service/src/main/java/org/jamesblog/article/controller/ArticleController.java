package org.jamesblog.article.controller;

import com.github.pagehelper.PageHelper;
import org.jamesblog.article.model.Article;
import org.jamesblog.article.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Created by jamescsh on 10/15/17.
 */
@RestController
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    /**
     * 获取文章列表
     * @param pageNo        第几页
     * @param pageSize      每页数量
     * @return              文章列表
     * @throws Exception
     */
    @RequestMapping(path = "/articles", method = RequestMethod.GET)
    public ResponseEntity getArticles(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                      @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize) throws Exception {
        PageHelper.startPage(pageNo, pageSize);
        return Optional.ofNullable(articleService.getArticles())
                .map(articles -> new ResponseEntity<List<Article>>(articles, HttpStatus.OK))
                .orElseThrow(() -> new Exception("getArticles throw Exception"));
    }

    /**
     * 获取文章
     * @param id            文章ID
     * @return
     * @throws Exception
     */
    @RequestMapping(path = "/article/{id}", method = RequestMethod.GET)
    public ResponseEntity getArticle(@PathVariable(value = "id") long id) throws Exception {
        return Optional.ofNullable(articleService.getArticleById(id))
                .map(article -> new ResponseEntity<Article>(article, HttpStatus.OK))
                .orElseThrow(() -> new Exception("getArticle throw Exception"));
    }

}
