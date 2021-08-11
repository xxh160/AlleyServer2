package com.edu.nju.alley.controller;

import com.edu.nju.alley.service.OSSService;
import com.edu.nju.alley.vo.OSSPolicyVO;
import com.edu.nju.alley.vo.OSSResultVO;
import com.edu.nju.alley.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/oss")
public class OSSController {

    private final OSSService ossService;

    @Autowired
    public OSSController(OSSService ossService) {
        this.ossService = ossService;
    }

    @GetMapping("/policy")
    public ResponseVO<OSSPolicyVO> policy() {
        return ResponseVO.<OSSPolicyVO>success().data(ossService.policy());
    }

    @PostMapping("/callback")
    public ResponseVO<OSSResultVO> callback(@RequestParam String filename,
                                            @RequestParam String size,
                                            @RequestParam String mimeType,
                                            @RequestParam String width,
                                            @RequestParam String height) {
        return ResponseVO.<OSSResultVO>success().data(ossService.callback(filename, size, mimeType, width, height));
    }

}
