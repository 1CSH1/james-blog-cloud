package org.jamesblog.tag.model;

import javax.persistence.Id;

/**
 * @Author: James-CSH
 * @Date: 10/25/17 10:46 PM
 */
public class Tag extends BaseModel {
    @Id
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