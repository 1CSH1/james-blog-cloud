package org.jamesblog.about.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.jamesblog.about.model.About;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.BaseMapper;

/**
 * @Author: James-CSH
 * @Date: 11/5/17 3:11 PM
 */
@Repository
@Mapper
public interface AboutMapper extends BaseMapper<About> {

    /**
     * 当前使用的信息
     */
    @Select("select * from about where is_use = 1 ")
    About selectByUse();

}
