package com.edu.nju.alley.dao;

import com.edu.nju.alley.po.MarkPO;

import java.util.List;

public interface MarkDataService {

    void insertMark(Integer archId,Integer score,Integer userId);

    List<MarkPO> getMarks(Integer archId);
}
