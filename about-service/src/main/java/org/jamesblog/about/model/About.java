package org.jamesblog.about.model;

/**
 * @Author: James-CSH
 * @Date: 11/5/17 3:11 PM
 */
public class About extends BaseModel{
    private long id;
    private String content;
    private int isUse;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getIsUse() {
        return isUse;
    }

    public void setIsUse(int isUse) {
        this.isUse = isUse;
    }
}
