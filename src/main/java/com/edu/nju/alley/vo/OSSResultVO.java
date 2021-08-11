package com.edu.nju.alley.vo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用于封装返回给回调函数的结果
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OSSResultVO {

    private String filename;

    private String size;

    private String mimeType;

    private String width;

    private String height;

}
