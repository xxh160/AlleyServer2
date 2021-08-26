package com.edu.nju.alley.util;

public class NoticeUtil {

    public static String commentSuccessNotice(String commentContent) {
        return "您的评论 [" + commentContent + "] 发布成功！";
    }

    public static String commentedNotice(String commentContent, String username) {
        return "您的评论 [" + commentContent + "] 被用户 [" + username + "] 评论啦！";
    }

}
