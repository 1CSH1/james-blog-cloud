package org.jamesblog.category.service;

import org.jamesblog.category.bean.CategoryBean;
import org.jamesblog.category.mapper.CategoryMapper;
import org.jamesblog.category.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: James-CSH
 * @Date: 10/24/17 10:40 PM
 */
@Service
public class CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    public List<Category> getCategoriesByArticleId(long id) {
        return categoryMapper.getCategoriesByArticleId(id);
    }

    public List<CategoryBean> getCategories() {
        return categoryMapper.getCategories();
    }

    public List<Long> getArticleIdsByCategoryName(String categoryName) {
        return categoryMapper.getArticleIdsByCategoryName(categoryName);
    }
}
