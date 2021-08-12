# Database

## Entity

### arch

|Column|Type|Description|
|:---:|:---:|:---:|
|arch_id|integer|主键|
|name|varchar(128)|建筑名|
|des|varchar(2048)|建筑描述|
|longitude|varchar(64)|经度，保留 6 位小数|
|latitude|varchar(64)|纬度，保留 6 位小数|

备注：

- 建筑评分后端实时计算

### user_info

|Column|Type|Description|
|:---:|:---:|:---:|
|user_id|integer|主键|
|open_id|varchar(256)|微信登录唯一标识|
|name|varchar(128)|用户名|
|gender|integer|enum(1,2)，1 为男，2 为女|
|avatar|varchar(1024)|头像 url|
|locate_auth|bool|定位权限|

候选键：open_id

备注：

- 系统 id 为 1，用户 id 从 2 开始

### notice

|Column|Type|Description|
|:---:|:---:|:---:|
|notice_id|integer|主键|
|sender_id|integer|发送通知的用户 id，可能是系统，可能是点赞者或是评论者|
|user_id|integer|被通知者的用户 id，也是 comment 的创建者|
|comment_id|integer|原评论 id，若没有则为 -1，但应该不会有这样的情况|
|content|varchar(1024)|通知内容|
|is_unread|bool|是否未读|

## Relationship

### comment

|Column|Type|Description|
|:---:|:---:|:---:|
|comment_id|integer|主键|
|arch_id|integer|评论所属建筑|
|user_id|integer|评论发表者|
|father_id|integer|父评论，如果没有则为 -1|
|content|varchar(2048)|评论内容|
|like_num|integer|点赞数|
|create_t|datetime|评论时间|
|picture|varchar(1024)|评论附图片的 url|

### like

|Column|Type|Description|
|:---:|:---:|:---:|
|user_id|integer|点赞者用户 id|
|comment_id|integer|被点赞的评论 id|

主键：user_id + comment_id

### mark

|Column|Type|Description|
|:---:|:---:|:---:|
|user_id|integer|评分者用户 id|
|arch_id|integer|建筑 id|
|score|integer|enum(1,2,3,4,5)，评分只有这 5 种情况|

主键：user_id + arch_id
