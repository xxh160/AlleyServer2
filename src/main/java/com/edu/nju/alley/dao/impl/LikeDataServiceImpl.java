package com.edu.nju.alley.dao.impl;

import com.edu.nju.alley.dao.LikeDataService;
import com.edu.nju.alley.dao.mapper.LikeMapper;
import com.edu.nju.alley.dao.support.LikeDSS;
import com.edu.nju.alley.po.LikePO;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

@Service
public class LikeDataServiceImpl implements LikeDataService {

    private final LikeMapper likeMapper;

    public LikeDataServiceImpl(LikeMapper likeMapper) {
        this.likeMapper = likeMapper;
    }

    @Override
    public boolean isExist(Integer userId, Integer commentId) {
        Optional<LikePO> likeOptional = likeMapper
                .selectOne(c -> c.where(LikeDSS.userId, isEqualTo(userId))
                        .and(LikeDSS.commentId, isEqualTo(commentId)));
        return likeOptional.isPresent();
    }

    @Override
    public void deleteLike(Integer userId, Integer commentId) {
        likeMapper.deleteByPrimaryKey(userId, commentId);
    }

    @Override
    public void insertLike(Integer userId, Integer commentId) {
        LikePO likePO = new LikePO(userId, commentId);
        likeMapper.insert(likePO);
    }

}
