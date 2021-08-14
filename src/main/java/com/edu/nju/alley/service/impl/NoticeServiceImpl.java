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
    public void read(Integer noticeId) {
        // 更新 NoticePO 的 isUnread 属性
        // Q: 诶这里不应该返回通知的内容吗

        // A: read 的作用是标识为已读 在 userService 里有一个返回用户所有通知的方法 在那里内容就返回了
    }

}
