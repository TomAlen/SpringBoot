package com.tomalen.springlanuch.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * comment
 * @author 
 */
@Data
public class Comment implements Serializable {
    private Integer id;

    /**
     * 父类id
     */
    private Integer parentId;

    /**
     * 父类类型
     */
    private Integer type;

    /**
     * 评论人id
     */
    private Integer commentor;

    /**
     * 创建时间
     */
    private Long gmtCreate;

    /**
     * 修改时间
     */
    private Long gmtModified;

    private Long likeCount;

    private String content;

    private Integer commentCount;

    private static final long serialVersionUID = 1L;

}