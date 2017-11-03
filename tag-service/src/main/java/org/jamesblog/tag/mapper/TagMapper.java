package org.jamesblog.tag.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.jamesblog.tag.bean.TagBean;
import org.jamesblog.tag.model.Tag;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.BaseMapper;

import java.util.List;

/**
 * @Author: James-CSH
 * @Date: 10/25/17 10:47 PM
 */
@Repository
@Mapper
public interface TagMapper extends BaseMapper<Tag> {

    @Select("select * from tag where id in (select tag_id from article_tag_rel where article_id = #{id})")
    List<Tag> getTagsByArticleId(long id);

    @Select("select a.*, count(b.id) as total from tag as a left join article_tag_rel as b on a.id = b.tag_id group by a.id ")
    List<TagBean> getTags();

    @Select("select b.article_id from tag as a, article_tag_rel as b where a.id = b.tag_id and a.name = #{tagName} ")
    List<Long> getArticleIdsByTagName(String tagName);
}
