package com.edu.nju.alley.po;

import lombok.Data;

@Data
public class NoticePO {

    private Integer noticeId;

    private Integer senderId;

    private Integer userId;

    private Integer commentId;

    private String content;

    private Boolean isUnread;

}