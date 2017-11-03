package org.jamesblog.article.mapper;

import com.google.common.base.Joiner;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.jamesblog.article.model.Article;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.BaseMapper;

import java.util.List;

/**
 * @Author: James-CSH
 * @Date: 10/15/17 10:52 PM
 */
@Repository
@Mapper
public interface ArticleMapper extends BaseMapper<Article> {
    @Select("<script>" +
                "select * from article where id in " +
                "<foreach item='item' index='index' collection='articleIds' open='(' separator=', ' close=')'>" +
                    "#{item}" +
                "</foreach>" +
            "</script>")
    List<Article> getArticlesByIds(@Param("articleIds") List<Long> articleIds);
}