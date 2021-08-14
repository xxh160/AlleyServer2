package com.edu.nju.alley.controller;

import com.edu.nju.alley.service.NoticeService;
import com.edu.nju.alley.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/notice")
public class NoticeController {

    private final NoticeService noticeService;

    @Autowired
    public NoticeController(NoticeService noticeService) {
        this.noticeService = noticeService;
    }

    @PostMapping("/read/{noticeId}")
    public ResponseVO<Object> read(@PathVariable Integer noticeId) {
        noticeService.read(noticeId);
        return ResponseVO.success();
    }

}
