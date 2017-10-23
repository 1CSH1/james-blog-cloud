package org.jamesblog.article.model;

import org.apache.ibatis.type.JdbcType;
import tk.mybatis.mapper.annotation.ColumnType;

import java.io.Serializable;

/**
 * Created by jamescsh on 10/14/17.
 */

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
