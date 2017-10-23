package org.jamesblog.article.model;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by jamescsh on 10/14/17.
 */

/**
 * 文章
 */
public class Article extends BaseModel {
    @Id
    private long id;
    private String title;
    private String subtitle;
    private String author;
    private String content;
    private int readNumber;
    private int commentNumber;
    private boolean isTop;



    public Article() {
    }

    public Article(String title, String subtitle, String author, String content, int readNumber, int commentNumber, boolean isTop) {
        this.title = title;
        this.subtitle = subtitle;
        this.author = author;
        this.content = content;
        this.readNumber = readNumber;
        this.commentNumber = commentNumber;
        this.isTop = isTop;
    }

    public Article(long id, String title, String subtitle, String author, String content, int readNumber, int commentNumber, boolean isTop) {
        this.id = id;
        this.title = title;
        this.subtitle = subtitle;
        this.author = author;
        this.content = content;
        this.readNumber = readNumber;
        this.commentNumber = commentNumber;
        this.isTop = isTop;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getReadNumber() {
        return readNumber;
    }

    public void setReadNumber(int readNumber) {
        this.readNumber = readNumber;
    }

    public int getCommentNumber() {
        return commentNumber;
    }

    public void setCommentNumber(int commentNumber) {
        this.commentNumber = commentNumber;
    }

    public boolean isTop() {
        return isTop;
    }

    public void setTop(boolean top) {
        isTop = top;
    }

//    public Set<Tag> getTags() {
//        return tags;
//    }
//
//    public void setTags(Set<Tag> tags) {
//        this.tags = tags;
//    }
//
//    public Set<Category> getCategories() {
//        return categories;
//    }
//
//    public void setCategories(Set<Category> categories) {
//        this.categories = categories;
//    }
//
//    public Set<Comment> getComments() {
//        return comments;
//    }
//
//    public void setComments(Set<Comment> comments) {
//        this.comments = comments;
//    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", subtitle='" + subtitle + '\'' +
                ", author='" + author + '\'' +
                ", content='" + content + '\'' +
                ", readNumber=" + readNumber +
                ", commentNumber=" + commentNumber +
                ", isTop=" + isTop +
//                ", tags=" + tags +
//                ", categories=" + categories +
//                ", comments=" + comments +
                "}" + super.toString();
    }
}
