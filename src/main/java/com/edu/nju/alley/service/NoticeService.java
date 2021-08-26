package com.edu.nju.alley.service;

import com.edu.nju.alley.vo.NoticeVO;

import java.util.List;

public interface NoticeService {

    List<NoticeVO> userNotices(Integer userId);

    void read(Integer noticeId);

    void buildSysNotice(Integer userId, Integer commentId, String content);

    void buildCustomNotice(Integer senderId, Integer userId, Integer commentId, String content);

}
