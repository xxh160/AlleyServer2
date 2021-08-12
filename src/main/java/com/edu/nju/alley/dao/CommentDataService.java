package com.edu.nju.alley.dao;

import com.edu.nju.alley.po.CommentPO;

import java.util.List;

public interface CommentDataService {

    List<CommentPO> getUserComments(Integer userId);

    List<CommentPO> getChildComments(Integer commentId);

    CommentPO getComment(Integer commentId);

}
