package org.jamesblog.article.bean;

import org.jamesblog.article.model.BaseModel;
import org.jamesblog.article.model.Comment;

import java.util.List;

/**
 * @Author: James-CSH
 * @Date: 10/29/17 5:08 PM
 */
public class CommentTreeBean extends BaseModel {

    private long id;
    private String name;
    private String content;
    private String email;
    private int status;
    private int pId;
    private String path;
    private List<CommentTreeBean> cComments;

    public CommentTreeBean() {

    }

    public CommentTreeBean(Comment comment) {
        this.init(comment);
    }

    public CommentTreeBean(Comment comment, List<CommentTreeBean> cComments) {
        this.cComments = cComments;
        this.init(comment);
    }

    private void init(Comment comment) {
        this.setId(comment.getId());
        this.setName(comment.getName());
        this.setContent(comment.getContent());
        this.setEmail(comment.getEmail());
        this.setStatus(comment.getStatus());
        this.setpId(comment.getpId());
        this.setPath(comment.getPath());
        this.setCreatedTime(comment.getCreatedTime());
        this.setModifiedTime(comment.getModifiedTime());
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

    public List<CommentTreeBean> getcComments() {
        return cComments;
    }

    public void setcComments(List<CommentTreeBean> cComments) {
        this.cComments = cComments;
    }
}
