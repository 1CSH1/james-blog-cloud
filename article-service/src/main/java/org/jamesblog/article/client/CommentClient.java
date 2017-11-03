package org.jamesblog.article.client;

import org.jamesblog.article.bean.CommentTreeBean;
import org.jamesblog.article.model.Comment;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @Author: James-CSH
 * @Date: 10/26/17 9:35 PM
 */
@FeignClient("comment-service")
public interface CommentClient {
    /**
     *  获取某篇文章的评论
     */
    @RequestMapping(value = "/article/{id}", method = RequestMethod.GET)
    ResponseEntity<List<CommentTreeBean>> getCommentsByArticleId(@PathVariable(value = "id") long id);

}
