package com.edu.nju.alley.po;

import com.edu.nju.alley.constant.Const;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NoticePO {

    private Integer noticeId;

    private Integer senderId;

    private Integer userId;

    private Integer commentId;

    private String content;

    private Boolean isUnread;

    public NoticePO content(String content) {
        this.content = content;
        return this;
    }

    public static NoticePO getSysNotice(Integer userId, Integer commentId) {
        NoticePO res = new NoticePO();
        res.setSenderId(Integer.parseInt(Const.SystemId.getId()));
        res.setUserId(userId);
        res.setCommentId(commentId);
        res.setIsUnread(true);
        return res;
    }

    public static NoticePO getDefaultNotice(Integer senderId, Integer userId, Integer commentId) {
        NoticePO res = new NoticePO();
        res.setSenderId(senderId);
        res.setUserId(userId);
        res.setCommentId(commentId);
        res.setIsUnread(true);
        return res;
    }

}