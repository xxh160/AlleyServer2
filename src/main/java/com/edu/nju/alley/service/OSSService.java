package com.edu.nju.alley.service;

import com.edu.nju.alley.vo.OSSPolicyVO;
import com.edu.nju.alley.vo.OSSResultVO;

public interface OSSService {

    OSSPolicyVO policy();

    OSSResultVO callback(String filename, String size, String mimeType, String width, String height);

}
