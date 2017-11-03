package org.jamesblog.article.model;

/**
 * Created by jamescsh on 10/14/17.
 */

import org.jamesblog.article.model.BaseModel;

/**
 * 标签
 */
public class Tag extends BaseModel {
    private long id;
    private String name;

    public Tag() {
    }

    public Tag(String name) {
        this.name = name;
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

    @Override
    public String toString() {
        return "Tag{" +
                "id=" + id +
                ", name='" + name + '\'' +
                "}, " + super.toString();
    }
}
