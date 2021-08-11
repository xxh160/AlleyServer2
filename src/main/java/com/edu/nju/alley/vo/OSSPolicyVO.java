package com.edu.nju.alley.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OSSPolicyVO {

    private String accessKeyId;

    private String policy;

    private String signature;

    private String dir;

    private String host;

    private String callback;

}
