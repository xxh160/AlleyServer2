package com.edu.nju.alley.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient(name = "wechat", url = "https://api.weixin.qq.com/")
public interface WechatService {

    @GetMapping("/sns/jscode2session")
    Object getUserOpenId(@RequestParam String appid,
                         @RequestParam String secret,
                         @RequestParam String js_code,
                         @RequestParam String grant_type);
}
