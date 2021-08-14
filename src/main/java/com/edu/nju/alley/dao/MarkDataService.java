package com.edu.nju.alley.dao;

import com.edu.nju.alley.po.MarkPO;

import java.util.List;

public interface MarkDataService {

    Object insertMark(Integer archId,Integer score);

    List<MarkPO> getMarks(Integer archId);
}
