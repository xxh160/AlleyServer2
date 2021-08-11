package com.edu.nju.alley.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OSSParamVO {

    private String callbackUrl;

    private String callbackBody;

    private String callbackBodyType;

    public OSSParamVO(String callbackUrl) {
        this.callbackUrl = callbackUrl;
        this.callbackBody = "filename=${object}&size=${size}&mimeType=${mimeType}&height=${imageInfo.height}&width=${imageInfo.width}";
        this.callbackBodyType = "application/x-www-form-urlencoded";
    }

}
