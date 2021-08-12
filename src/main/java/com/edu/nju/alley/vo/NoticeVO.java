package com.edu.nju.alley.vo;

import com.edu.nju.alley.po.NoticePO;
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

    public static NoticeVO buildVO(NoticePO notice) {
        return new NoticeVO(notice.getNoticeId(),
                notice.getSenderId(),
                notice.getCommentId(),
                notice.getUserId(),
                notice.getContent(),
                notice.getIsUnread());
    }

}
