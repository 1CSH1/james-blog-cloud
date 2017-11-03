package org.jamesblog.tag.controller;

import org.jamesblog.tag.bean.TagBean;
import org.jamesblog.tag.model.Tag;
import org.jamesblog.tag.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.util.Exceptions;

import java.util.List;
import java.util.Optional;

/**
 * @Author: James-CSH
 * @Date: 10/25/17 10:48 PM
 */
@RestController
public class TagController {

    @Autowired
    private TagService tagService;

    @RequestMapping(value = "/article/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<Tag>> getTagsByArticleId(@PathVariable(value = "id") long id) throws Exception {
        return Optional.ofNullable(tagService.getTagsByArticleId(id))
                .map(tags -> new ResponseEntity<List<Tag>>(tags, HttpStatus.OK))
                .orElseThrow(() -> new Exception("getTagsByArticleId() method throw Exception"));
    }

    @RequestMapping(value = "/tags", method = RequestMethod.GET)
    public ResponseEntity<List<TagBean>> getTags() throws Exception {
        return Optional.ofNullable(tagService.getTags())
                .map(tags -> new ResponseEntity<List<TagBean>>(tags, HttpStatus.OK))
                .orElseThrow(() -> new Exception("getCategories() throw Exception"));
    }

    @RequestMapping(value = "/tag/name/{tagName}", method = RequestMethod.GET)
    public ResponseEntity<List<Long>> getArticleIdsByTagName(@PathVariable(value = "tagName") String tagName) throws Exception {
        assert null != tagName;
        return Optional.ofNullable(tagService.getArticleIdsByTagName(tagName))
                .map(articleIds -> new ResponseEntity<List<Long>>(articleIds, HttpStatus.OK))
                .orElseThrow(() -> new Exception("getArticleIdsByCategoryName() throw Exception"));
    }
}
