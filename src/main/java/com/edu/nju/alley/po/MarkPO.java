package com.edu.nju.alley.po;

import lombok.Data;

@Data
public class MarkPO {

    private Integer userId;

    private Integer archId;

    private Integer score;

    public MarkPO(Integer userId, Integer archId, Integer score) {
        this.userId = userId;
        this.archId = archId;
        this.score = score;
    }
}