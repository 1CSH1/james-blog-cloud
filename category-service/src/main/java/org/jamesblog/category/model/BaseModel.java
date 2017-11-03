package org.jamesblog.category.model;

import java.io.Serializable;

/**
 * 基础 Model 类
 */
public class BaseModel implements Serializable{

    /**
     * 创建时间
     */
    private long createdTime;

    /**
     * 修改时间
     */
    private long modifiedTime;

    public BaseModel() {
    }

    public long getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(long createdTime) {
        this.createdTime = createdTime;
    }

    public long getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(long modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    @Override
    public String toString() {
        return "BaseModel{" +
                "createdTime=" + createdTime +
                ", modifiedTime=" + modifiedTime +
                '}';
    }
}
