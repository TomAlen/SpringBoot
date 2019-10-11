package com.tomalen.springlanuch.DTO;

import com.tomalen.springlanuch.pojo.User;
import lombok.Data;

/**
 * Author:钟炜宏
 * Date:2019/8/27
 * 问题数据传输模型
 */
@Data
public class QuestionDTO {

    private Integer id;
    private String title;//发布题目
    private String description;//描述
    private String tag;//标签
    private Long gmtCreate;//创建时间
    private Long gmtModified;//修改时间
    private Integer creator;//创造者数
    private Integer viewCount;//观看数
    private Integer commentCount;//评论数
    private Integer likeCount;//点赞数
    private User user;

}
