package com.edu.nju.alley.dao.impl;

import com.edu.nju.alley.dao.CommentDataService;
import com.edu.nju.alley.dao.mapper.CommentMapper;
import com.edu.nju.alley.dao.support.CommentDSS;
import com.edu.nju.alley.po.CommentPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static org.mybatis.dynamic.sql.SqlBuilder.and;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

@Service
public class CommentDataServiceImpl implements CommentDataService {

    private final CommentMapper commentMapper;

    @Autowired
    public CommentDataServiceImpl(CommentMapper commentMapper) {
        this.commentMapper = commentMapper;
    }

    @Override
    public List<CommentPO> getUserComments(Integer userId) {
        return commentMapper
                .select(c -> c.where(CommentDSS.userId, isEqualTo(userId)));
    }

    @Override
    public List<CommentPO> getChildComments(Integer commentId) {
        return commentMapper
                .select(c -> c.where(CommentDSS.fatherId, isEqualTo(commentId)));
    }

    @Override
    public List<CommentPO> getArchComments(Integer archId) {
        return commentMapper
                .select(c -> c.where(CommentDSS.archId, isEqualTo(archId), and(CommentDSS.fatherId, isEqualTo(-1))));
    }

    @Override
    public CommentPO getComment(Integer commentId) {
        Optional<CommentPO> commentOptional = commentMapper.selectByPrimaryKey(commentId);
        return commentOptional.orElse(CommentPO.getNullInstance());
    }
}
