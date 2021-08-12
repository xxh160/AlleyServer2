package com.edu.nju.alley.service;

import com.edu.nju.alley.vo.NoticeVO;

import java.util.List;

public interface NoticeService {

    // api 设计严重失误
    List<NoticeVO> userNotices(Integer userId);

}
