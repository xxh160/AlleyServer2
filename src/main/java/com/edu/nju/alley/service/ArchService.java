package com.edu.nju.alley.service;

import com.edu.nju.alley.dto.ArchCommentDTO;
import com.edu.nju.alley.vo.ArchVO;
import com.edu.nju.alley.vo.CommentVO;

public interface ArchService {

    ArchVO view(Integer archId);

    CommentVO comment(ArchCommentDTO archCommentDTO);

    Object mark(Integer archId,Integer score);

}
