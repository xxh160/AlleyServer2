package com.edu.nju.alley.dao;

import com.edu.nju.alley.po.CommentPO;

import java.util.List;

public interface CommentDataService {

    List<CommentPO> getUserComments(Integer userId);

    List<CommentPO> getChildComments(Integer commentId);

    List<CommentPO> getArchComments(Integer archId);

    CommentPO getComment(Integer commentId);

    void insertComment(CommentPO commentPO);

}
