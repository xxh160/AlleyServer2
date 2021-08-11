package com.edu.nju.alley.constant;

import lombok.Getter;

@Getter
public enum Score {

    One(1),
    Two(2),
    Three(3),
    Four(4),
    Five(5);

    private final int score;

    Score(int score) {
        this.score = score;
    }

}
