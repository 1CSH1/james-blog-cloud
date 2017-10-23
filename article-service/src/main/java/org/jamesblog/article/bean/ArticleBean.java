package org.jamesblog.article.bean;

import org.jamesblog.article.model.Article;
import org.jamesblog.article.model.Category;
import org.jamesblog.article.model.Comment;
import org.jamesblog.article.model.Tag;

import java.util.Set;

/**
 * @Author: James-CSH
 * @Date: 10/23/17 11:24 PM
 */
public class ArticleBean extends Article {
    private Set<Tag> tags;
    private Set<Category> categories;
    private Set<Comment> comments;

    public Set<Tag> getTags() {
        return tags;
    }

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }
}
