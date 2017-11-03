package org.jamesblog.article.service;

import org.jamesblog.article.bean.ArticleBean;
import org.jamesblog.article.bean.ArticleListBean;
import org.jamesblog.article.client.CategoryClient;
import org.jamesblog.article.client.CommentClient;
import org.jamesblog.article.client.TagClient;
import org.jamesblog.article.mapper.ArticleMapper;
import org.jamesblog.article.model.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by jamescsh on 10/15/17.
 */
@Service
public class ArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    @Autowired
    private CategoryClient categoryClient;

    @Autowired
    private TagClient tagClient;

    @Autowired
    private CommentClient commentClient;

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
    public ArticleBean getArticleById(Long id) {
        Article article = articleMapper.selectByPrimaryKey(id);
        ArticleBean articleBean = new ArticleBean();
        articleBean.setArticle(article);
        articleBean.setCategories(categoryClient.getCategoriesByArticleId(id).getBody());
        articleBean.setTags(tagClient.getTagsByArticleId(id).getBody());
        articleBean.setComments(commentClient.getCommentsByArticleId(id).getBody());
        return articleBean;
    }

    /**
     * 获取某个分类的文章
     * @param categoryName      分类名
     * @return
     */
    public List<Article> getArticlesByCategoryName(String categoryName) {
        // 调用 category-service 获取该分类下的文章ID
        List<Long> articleIds = categoryClient.getArticleIdsByCategoryName(categoryName).getBody();
        if (null == articleIds || articleIds.isEmpty()) {
            return new ArrayList<>();
        }
        return articleMapper.getArticlesByIds(articleIds);
    }

    /**
     * 获取某个标签的文章
     * @param tagName       标签名
     * @return
     */
    public List<Article> getArticlesByTagName(String tagName) {
        List<Long> articleIds = tagClient.getArticleIdsByTagName(tagName).getBody();
        if (null == articleIds || articleIds.isEmpty()) {
            return new ArrayList<>();
        }
        return articleMapper.getArticlesByIds(articleIds);
    }
}
