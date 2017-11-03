package org.jamesblog.comment.mapper;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.StatementType;
import org.jamesblog.comment.model.Comment;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.BaseMapper;

import java.util.List;

/**
 * @Author: James-CSH
 * @Date: 10/26/17 9:42 PM
 */
@Repository
@Mapper
public interface CommentMapper extends BaseMapper<Comment> {

    //---------------- Select -----------------------

    @Select(" select * from comment where article_id = #{id} ")
    List<Comment> getCommentsByArticleId(long id);

    @Select(" select * from comment where id = #{id} ")
    Comment getCommentById(long id);

    @Select(" select * from comment where id = #{id}")
    Comment selectById(long id);


    //---------------- Insert -----------------------

    @Insert(" insert into comment (name, content, email, status, article_id, p_id, created_time, modified_time, path) " +
            " values (#{comment.name}, #{comment.content}, #{comment.email}, #{comment.status}, #{comment.articleId}, " +
            " #{comment.pId}, #{comment.createdTime}, #{comment.modifiedTime}, #{comment.path}) ")
    @SelectKey(statementType = StatementType.STATEMENT, statement = " select LAST_INSERT_ID() " , keyProperty = "comment.id", before = false, resultType = long.class)
    long insertCommentReturnId(@Param("comment") Comment comment);
}
