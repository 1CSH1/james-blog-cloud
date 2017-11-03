package org.jamesblog.article.client;

import org.jamesblog.article.model.Tag;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @Author: James-CSH
 * @Date: 10/25/17 10:40 PM
 */
@FeignClient("tag-service")
public interface TagClient {

    /**
     * 通过文章ID获取对应的标签
     * @param id            文章ID
     */
    @RequestMapping(value = "/article/{id}", method = RequestMethod.GET)
    ResponseEntity<List<Tag>> getTagsByArticleId(@PathVariable(value = "id") long id);

    /**
     * 通过标签名字获取该标签下的文章ID
     */
    @RequestMapping(value = "/tag/name/{tagName}", method = RequestMethod.GET)
    ResponseEntity<List<Long>> getArticleIdsByTagName(@PathVariable(value = "tagName") String tagName);
}
