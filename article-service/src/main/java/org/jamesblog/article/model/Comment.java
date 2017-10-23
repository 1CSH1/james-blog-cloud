package org.jamesblog.article.model;

/**
 * Created by jamescsh on 10/14/17.
 */

/**
 * 评论
 */
public class Comment extends BaseModel {
    private long id;
    private String name;
    private String content;
    private String email;
    private int status;
    private Comment pComment;

    public Comment() {
    }

    public Comment(String name, String content, String email, int status) {
        this.name = name;
        this.content = content;
        this.email = email;
        this.status = status;
        this.pComment = new Comment();
    }

    public Comment(String name, String content, String email, int status, Comment pComment) {
        this.name = name;
        this.content = content;
        this.email = email;
        this.status = status;
        this.pComment = pComment;
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

    public Comment getpComment() {
        return pComment;
    }

    public void setpComment(Comment pComment) {
        this.pComment = pComment;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", content='" + content + '\'' +
                ", email='" + email + '\'' +
                ", status=" + status +
                ", pComment=" + pComment +
                "}, " + super.toString();
    }
}
