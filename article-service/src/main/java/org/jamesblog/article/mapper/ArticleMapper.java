package org.jamesblog.article.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.jamesblog.article.model.Article;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.BaseMapper;

/**
 * @Author: James-CSH
 * @Date: 10/15/17 10:52 PM
 */
@Repository
@Mapper
public interface ArticleMapper extends BaseMapper<Article> {
}
