package org.jamesblog.tag.service;

import org.jamesblog.tag.bean.TagBean;
import org.jamesblog.tag.mapper.TagMapper;
import org.jamesblog.tag.model.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: James-CSH
 * @Date: 10/25/17 10:48 PM
 */
@Service
public class TagService {

    @Autowired
    private TagMapper tagMapper;

    public List<Tag> getTagsByArticleId(long id) {
        return tagMapper.getTagsByArticleId(id);
    }

    public List<TagBean> getTags() {
        return tagMapper.getTags();
    }

    public List<Long> getArticleIdsByTagName(String tagName) {
        return tagMapper.getArticleIdsByTagName(tagName);
    }
}
