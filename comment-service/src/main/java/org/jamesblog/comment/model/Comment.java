package org.jamesblog.comment.model;

/**
 * Created by jamescsh on 10/14/17.
 */

import javax.persistence.Id;

/**
 * 评论
 */
public class Comment extends BaseModel {
    @Id
    private long id;
    private String name;
    private String content;
    private String email;
    private int status;
    private long pId;
    private String path;
    private long articleId;

    public Comment() {
    }

    public Comment(String name, String content, String email, int status) {
        this.name = name;
        this.content = content;
        this.email = email;
        this.status = status;
    }

    public Comment(String name, String content, String email, int status, int pId, String path) {
        this.name = name;
        this.content = content;
        this.email = email;
        this.status = status;
        this.pId = pId;
        this.path = path;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public long getpId() {
        return pId;
    }

    public void setpId(long pId) {
        this.pId = pId;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public long getArticleId() {
        return articleId;
    }

    public void setArticleId(long articleId) {
        this.articleId = articleId;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", content='" + content + '\'' +
                ", email='" + email + '\'' +
                ", status=" + status +
                ", pId=" + pId +
                ", path=" + path +
                "}, " + super.toString();
    }
}
