package org.jamesblog.comment.controller;

import org.jamesblog.comment.bean.CommentAddBean;
import org.jamesblog.comment.bean.CommentTreeBean;
import org.jamesblog.comment.model.Comment;
import org.jamesblog.comment.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * @Author: James-CSH
 * @Date: 10/26/17 9:41 PM
 */
@RestController
public class CommentController {

    @Autowired
    private CommentService commentService;

    @RequestMapping(value = "/article/{id}", method = RequestMethod.GET)
    public ResponseEntity getCommentsByArticleId(@PathVariable(value = "id") long id) throws Exception {
        return Optional.ofNullable(commentService.getCommentsByArticleId(id))
                .map(comments -> new ResponseEntity<List<CommentTreeBean>>(comments, HttpStatus.OK))
                .orElseThrow(() -> new Exception("getCommentsByArticleId() method throw Exception"));
    }

    @RequestMapping(value = "/article/{id}/add", method = RequestMethod.PUT)
    public ResponseEntity addCommentPut(@PathVariable(value = "id") long articleId,
                                        @RequestBody CommentAddBean commentAddBean) throws Exception {
        assert 0 != articleId;
        assert null != commentAddBean.getName();
        assert null != commentAddBean.getEmail();
        assert null != commentAddBean.getContent();
        return Optional.ofNullable(commentService.addComment(articleId, commentAddBean.getPid(),
                commentAddBean.getName(), commentAddBean.getEmail(), commentAddBean.getContent()))
                .map(noContent -> new ResponseEntity<>(HttpStatus.NO_CONTENT))
                .orElseThrow(() -> new Exception("addComment() method throw Exception"));
    }

}
