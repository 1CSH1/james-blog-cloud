package org.jamesblog.article.bean;

import com.github.pagehelper.PageHelper;
import org.jamesblog.article.model.Article;
import org.jamesblog.article.model.Category;
import org.jamesblog.article.model.Comment;
import org.jamesblog.article.model.Tag;

import java.util.List;

/**
 * @Author: James-CSH
 * @Date: 10/23/17 11:24 PM
 */
public class ArticleBean {
    private Article article;
    private List<Tag> tags;
    private List<Category> categories;
    private List<CommentTreeBean> comments;
    private int pageNo = 0;
    private int pageSize = 5;
    private boolean isFirst = false;
    private boolean isLast = false;

    public ArticleBean() {
    }

    public ArticleBean(Article article, List<Tag> tags, List<Category> categories, List<CommentTreeBean> comments) {
        this.article = article;
        this.tags = tags;
        this.categories = categories;
        this.comments = comments;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public List<CommentTreeBean> getComments() {
        return comments;
    }

    public void setComments(List<CommentTreeBean> comments) {
        this.comments = comments;
    }
}
