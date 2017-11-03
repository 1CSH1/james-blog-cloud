package org.jamesblog.category.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.jamesblog.category.bean.CategoryBean;
import org.jamesblog.category.model.Category;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.BaseMapper;

import java.util.List;


/**
 * @Author: James-CSH
 * @Date: 10/24/17 10:41 PM
 */
@Repository
@Mapper
public interface CategoryMapper extends BaseMapper<Category> {
    @Select("select * from category where id in (select category_id from article_category_rel where article_id = #{id})")
    List<Category> getCategoriesByArticleId(long id);

    @Select("select a.*, count(b.id) as total from category as a left join article_category_rel as b on a.id = b.category_id group by a.id ")
    List<CategoryBean> getCategories();

    @Select("select b.article_id from category as a, article_category_rel as b where a.id = b.category_id and a.name = #{categoryName} ")
    List<Long> getArticleIdsByCategoryName(String categoryName);
}
