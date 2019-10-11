package com.tomalen.springlanuch.DTO;

import com.tomalen.springlanuch.pojo.User;
import lombok.Data;

/**
 * Author:钟炜宏
 * Date:2019/8/31
 */
@Data
public class CommentDTO {

    private Integer id;

    private Integer parentId;

    private Integer type;

    private Integer commentor;

    private Long gmtCreate;

    private Long gmtModified;

    private Long likeCount;

    private String content;

    private Integer commentCount;

    private User user;



}
