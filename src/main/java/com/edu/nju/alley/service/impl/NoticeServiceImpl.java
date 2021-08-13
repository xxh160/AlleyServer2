package com.edu.nju.alley.service.impl;

import com.edu.nju.alley.dao.NoticeDataService;
import com.edu.nju.alley.service.NoticeService;
import com.edu.nju.alley.vo.NoticeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NoticeServiceImpl implements NoticeService {

    private final NoticeDataService noticeDataService;

    @Autowired
    public NoticeServiceImpl(NoticeDataService noticeDataService) {
        this.noticeDataService = noticeDataService;
    }

    @Override
    public List<NoticeVO> userNotices(Integer userId) {
        return noticeDataService
                .getUserNotices(userId)
                .stream()
                .map(NoticeVO::buildVO)
                .collect(Collectors.toList());
    }

    //阅读通知并标记通知为已读
    @Override
    public Object read(Integer noticeId) {
        //更新NoticePO的isUnread属性
        //诶这里不应该返回通知的内容吗
        return null;
    }

}
