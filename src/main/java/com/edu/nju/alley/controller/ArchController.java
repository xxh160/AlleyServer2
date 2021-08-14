package com.edu.nju.alley.controller;

import com.edu.nju.alley.dto.ArchCommentDTO;
import com.edu.nju.alley.service.ArchService;
import com.edu.nju.alley.vo.ArchVO;
import com.edu.nju.alley.vo.ArchViewVO;
import com.edu.nju.alley.vo.CommentVO;
import com.edu.nju.alley.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/arch")
public class ArchController {

    private final ArchService archService;

    @Autowired
    public ArchController(ArchService archService) {
        this.archService = archService;
    }

    @GetMapping("/view/{archId}")
    public ResponseVO<ArchVO> view(@PathVariable Integer archId) {
        return ResponseVO
                .<ArchVO>success()
                .data(archService.view(archId));
    }

    @PostMapping("/comment")
    public ResponseVO<CommentVO> comment(@RequestBody ArchCommentDTO archCommentDTO) {
        return ResponseVO
                .<CommentVO>success()
                .data(archService.comment(archCommentDTO));
    }

    @PostMapping("/mark/{archId}")
    public ResponseVO<Object> mark(@PathVariable Integer archId, @RequestParam Integer score, @RequestParam Integer userId) {
        archService.mark(archId,score,userId);
        return ResponseVO.success();
    }

    @GetMapping("/all")
    public ResponseVO<List<ArchViewVO>> all() {
        return ResponseVO
                .<List<ArchViewVO>>success()
                .data(archService.all());
    }

}
