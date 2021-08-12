package com.edu.nju.alley.dao;

import com.edu.nju.alley.po.NoticePO;

import java.util.List;

public interface NoticeDataService {

    List<NoticePO> getUserNotices(Integer userId);

}
