package com.edu.nju.alley.po;

import lombok.Data;

@Data
public class LikePO {

    private Integer userId;

    private Integer commentId;

    public LikePO(Integer userId, Integer commentId) {
        this.userId = userId;
        this.commentId = commentId;
    }

}