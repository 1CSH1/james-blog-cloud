package org.jamesblog.article.bean;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.jamesblog.article.model.Article;

import java.util.List;

/**
 * @Author: James-CSH
 * @Date: 10/26/17 10:53 PM
 */
public class ArticleListBean {

    private List<Article> articles;
    private int pageNo = 0;
    private int pageSize = 5;
    private boolean isFirst = false;
    private boolean isLast = false;

    public ArticleListBean(Page<Article> page) {
        init(page);
    }

    public ArticleListBean(List<Article> articles, Page<Article> page) {
        this.articles = articles;
        init(page);
    }

    private void init(Page<Article> page) {
        this.pageNo = page.getPageNum();
        this.pageSize = page.getPageSize();
        if (this.pageNo <= 1) {
            this.isFirst = true;
        }
        if (this.pageNo >= page.getPages()) {
            this.isLast = true;
        }
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public boolean getIsFirst() {
        return isFirst;
    }

    public void setIsFirst(boolean isFirst) {
        isFirst = isFirst;
    }

    public boolean getIsLast() {
        return isLast;
    }

    public void setIsLast(boolean isLast) {
        isLast = isLast;
    }
}
