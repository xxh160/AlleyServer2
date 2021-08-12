package com.edu.nju.alley.service.impl;

import com.edu.nju.alley.dao.NoticeDataService;
import com.edu.nju.alley.service.NoticeService;
import com.edu.nju.alley.vo.NoticeVO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NoticeServiceImpl implements NoticeService {

    private final NoticeDataService noticeDataService;

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

}
