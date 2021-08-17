package com.edu.nju.alley.service;

import com.edu.nju.alley.vo.ArchVO;
import com.edu.nju.alley.vo.ArchViewVO;

import java.util.List;

public interface ArchService {

    ArchVO view(Integer archId);

    void mark(Integer archId, Integer score, Integer userId);

    List<ArchViewVO> all();
}
