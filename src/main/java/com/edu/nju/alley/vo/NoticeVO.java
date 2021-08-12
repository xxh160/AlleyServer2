package com.edu.nju.alley.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NoticeVO {

    private Integer noticeId;

    private Integer senderId;

    private Integer commentId;

    private Integer userId;

    private String content;

    private Boolean isUnread;

}
