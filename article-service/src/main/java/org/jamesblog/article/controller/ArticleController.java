package org.jamesblog.article.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.jamesblog.article.bean.ArticleBean;
import org.jamesblog.article.bean.ArticleListBean;
import org.jamesblog.article.model.Article;
import org.jamesblog.article.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
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
        Page<Article> page = PageHelper.startPage(pageNo, pageSize);
        return Optional.ofNullable(new ArticleListBean(articleService.getArticles(), page))
                .map(articleListBeans -> new ResponseEntity<ArticleListBean>(articleListBeans, HttpStatus.OK))
                .orElseThrow(() -> new Exception("getArticles throw Exception") );
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
                .map(article -> new ResponseEntity<ArticleBean>(article, HttpStatus.OK))
                .orElseThrow(() -> new Exception("getArticle throw Exception"));
    }

    /**
     * 获取某个分类名称的文章
     * @param categoryName      分类名称
     * @param pageNo            第几页
     * @param pageSize          每页多少条记录
     * @return
     * @throws Exception
     */
    @RequestMapping(path = "/articles/category", method = RequestMethod.GET)
    public ResponseEntity getArticlesByCategoryName(@RequestParam(value = "categoryName") String categoryName,
                                                    @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                    @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize ) throws Exception {
        assert null != categoryName;
        Page<Article> page = PageHelper.startPage(pageNo, pageSize);
        return Optional.ofNullable(new ArticleListBean(articleService.getArticlesByCategoryName(categoryName), page))
        .map(articleListBeans -> new ResponseEntity<ArticleListBean>(articleListBeans, HttpStatus.OK))
        .orElseThrow(() -> new Exception("getArticlesByCategoryName throw Exception"));
    }

    /**
     * 获取某个标签名称的文章
     * @param tagName       标签名
     * @param pageNo        第几页
     * @param pageSize      每页多少条记录
     * @return
     * @throws Exception
     */
    @RequestMapping(path = "/articles/tag", method = RequestMethod.GET)
    public ResponseEntity getArticlesByTagName(@RequestParam(value = "tagName") String tagName,
                                               @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                               @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize ) throws Exception {
        assert null != tagName;
        Page<Article> page = PageHelper.startPage(pageNo, pageSize);
        return Optional.ofNullable(new ArticleListBean(articleService.getArticlesByTagName(tagName), page))
                .map(articleListBeans -> new ResponseEntity<ArticleListBean>(articleListBeans, HttpStatus.OK))
                .orElseThrow(() -> new Exception("getArticlesByCategoryName throw Exception"));
    }
}
