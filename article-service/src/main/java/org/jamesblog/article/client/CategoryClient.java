package org.jamesblog.article.client;

import org.jamesblog.article.model.Category;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @Author: James-CSH
 * @Date: 10/24/17 10:47 PM
 */
@FeignClient("category-service")
public interface CategoryClient {
    @RequestMapping(value = "/article/{id}", method = RequestMethod.GET)
    ResponseEntity<List<Category>> getCategoriesByArticleId(@PathVariable(value = "id") long id);

    @RequestMapping(value = "/category/name/{categoryName}", method = RequestMethod.GET)
    ResponseEntity<List<Long>> getArticleIdsByCategoryName(@PathVariable(value = "categoryName") String categoryName);
}
