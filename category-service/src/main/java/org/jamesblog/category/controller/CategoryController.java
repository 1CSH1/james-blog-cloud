package org.jamesblog.category.controller;

import org.jamesblog.category.bean.CategoryBean;
import org.jamesblog.category.model.Category;
import org.jamesblog.category.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

/**
 * @Author: James-CSH
 * @Date: 10/24/17 10:40 PM
 */
@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    /**
     * 获取某个ID的文章的分类
     * @param id        文章ID
     */
    @RequestMapping(value = "/article/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<Category>> getCategoriesByArticleId(@PathVariable(value = "id") long id) throws Exception {
        return Optional.ofNullable(categoryService.getCategoriesByArticleId(id))
                .map(categories -> new ResponseEntity<List<Category>>(categories, HttpStatus.OK))
                .orElseThrow(() -> new Exception("getCategoriesByArticleId() throw Exception"));
    }

    /**
     * 获取所有分类
     */
    @RequestMapping(value = "/categories", method = RequestMethod.GET)
    public ResponseEntity<List<CategoryBean>> getCategories() throws Exception {
        return Optional.ofNullable(categoryService.getCategories())
                .map(categories -> new ResponseEntity<List<CategoryBean>>(categories, HttpStatus.OK))
                .orElseThrow(() -> new Exception("getCategories() throw Exception"));
    }

    /**
     * 获取分类名称为 categoryName 的所有文章ID
     * @param categoryName      分类名称
     */
    @RequestMapping(value = "/category/name/{categoryName}", method = RequestMethod.GET)
    public ResponseEntity<List<Long>> getArticleIdsByCategoryName(@PathVariable(value = "categoryName") String categoryName) throws Exception {
        assert null != categoryName;
        return Optional.ofNullable(categoryService.getArticleIdsByCategoryName(categoryName))
                .map(articleIds -> new ResponseEntity<List<Long>>(articleIds, HttpStatus.OK))
                .orElseThrow(() -> new Exception("getArticleIdsByCategoryName() throw Exception"));
    }

}
