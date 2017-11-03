package org.jamesblog.comment.service;

import org.jamesblog.comment.bean.CommentTreeBean;
import org.jamesblog.comment.common.CommentConstant;
import org.jamesblog.comment.mapper.CommentMapper;
import org.jamesblog.comment.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: James-CSH
 * @Date: 10/26/17 9:42 PM
 */
@Service
public class CommentService {

    @Autowired
    private CommentMapper commentMapper;

    /**
     * 获取评论，并封装成树状格式
     * @param articleId        文章ID
     */
    public List<CommentTreeBean> getCommentsByArticleId(long articleId) {
        List<Comment> comments = commentMapper.getCommentsByArticleId(articleId);
        // 进行构造树
        List<CommentTreeBean> coverComments = new ArrayList<>();
        for (int i = 0; i < comments.size(); i ++) {
            Comment comment = comments.get(i);
            if (comment.getId() == comment.getpId()) {
                // 根节点
                coverComments.add(new CommentTreeBean(comment));
            } else {
                // 子节点
                CommentTreeBean root = null;
                String[] paths = comment.getPath().split(";");
                // 获取根节点
                for (int j = 0; j < coverComments.size(); j ++) {
                    if (coverComments.get(j).getId() == Long.parseLong(paths[0])) {
                        root = coverComments.get(j);
                        break;
                    }
                }
                CommentTreeBean parent = root;
                // 找到父节点
                for (int j = 1; j < paths.length - 1; j ++) {
                    List<CommentTreeBean> parentList = parent.getcComments();
                    for (int k = 0; k < parentList.size(); k++) {
                        if (parentList.get(k).getId() == Long.parseLong(paths[j])) {
                            parent = parentList.get(k);
                            break;
                        }
                    }
                }

                // 设置子节点
                if (null == parent.getcComments()) {
                    List<CommentTreeBean> child = new ArrayList<>();
                    child.add(new CommentTreeBean(comment));
                    parent.setcComments(child);
                } else {
                    parent.getcComments().add(new CommentTreeBean(comment));
                }
            }
        }

        return coverComments;
    }

    /**
     * 添加评论
     * @param articleId         文章ID
     * @param pId               父评论ID
     * @param name              名字
     * @param email             邮箱
     * @param content           内容
     */
    public boolean addComment(long articleId, long pId, String name, String email, String content) throws Exception {
        if (pId > 0) {
            Comment pComment = new Comment();
            pComment.setId(pId);
            pComment = commentMapper.selectById(pId);
            if (null == pComment) {
                throw new Exception("doesn't exists comment with id is " + pId);
            }
            Comment comment = new Comment();
            comment.setName(name);
            comment.setEmail(email);
            comment.setContent(content);
            comment.setStatus(CommentConstant.COMMENT_STATUS_A);
            comment.setArticleId(articleId);
            comment.setPath("0");
            long curTime = System.currentTimeMillis();
            comment.setCreatedTime(curTime);
            comment.setModifiedTime(curTime);
            commentMapper.insertCommentReturnId(comment);
            comment.setPath(pComment.getPath() + comment.getId() + ";");
            comment.setpId(pComment.getId());
            commentMapper.updateByPrimaryKey(comment);
        } else {
            // 直接插入数据库
            Comment comment = new Comment();
            comment.setName(name);
            comment.setEmail(email);
            comment.setContent(content);
            comment.setStatus(CommentConstant.COMMENT_STATUS_A);
            comment.setArticleId(articleId);
            comment.setPath("0");
            long curTime = System.currentTimeMillis();
            comment.setCreatedTime(curTime);
            comment.setModifiedTime(curTime);
            commentMapper.insertCommentReturnId(comment);
            comment.setPath(comment.getId() + ";");
            comment.setpId(comment.getId());
            commentMapper.updateByPrimaryKey(comment);
        }

        return true;
    }
}
