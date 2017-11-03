package org.jamesblog.category.bean;

import org.jamesblog.category.model.Category;

/**
 * @Author: James-CSH
 * @Date: 11/1/17 10:28 PM
 */
public class CategoryBean extends Category {

    private int total;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
