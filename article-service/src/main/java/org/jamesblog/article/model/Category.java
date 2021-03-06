package org.jamesblog.article.model;

/**
 * Created by jamescsh on 10/14/17.
 */

import org.jamesblog.article.model.BaseModel;

import javax.persistence.Id;

/**
 * 分类
 */
public class Category extends BaseModel {

    private long id;
    private String name;

    public Category() {
    }

    public Category(String name) {
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
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                "}, " + super.toString();
    }
}
