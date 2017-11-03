package org.jamesblog.article.model;

import org.jamesblog.article.model.BaseModel;


/**
 * 评论
 *
 * Created by jamescsh on 10/14/17.
 */
public class Comment extends BaseModel {
    private long id;
    private String name;
    private String content;
    private String email;
    private int status;
    private int pId;
    private String path;

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

    public int getpId() {
        return pId;
    }

    public void setpId(int pId) {
        this.pId = pId;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
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
