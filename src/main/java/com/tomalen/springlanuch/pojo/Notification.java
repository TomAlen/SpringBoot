package com.tomalen.springlanuch.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * notification
 * @author 
 */
@Data
public class Notification implements Serializable {
    private Integer id;

    /**
     * 回复的人
     */
    private Integer notifier;

    /**
     * 消息接收者
     */
    private Integer receiver;

    /**
     * 外键
     */
    private Integer outerId;

    /**
     * 回复或者评论
     */
    private Integer notifiedType;

    /**
     * 创建时间
     */
    private Long gmtCreate;

    /**
     * 消息未读或者已读
     */
    private Integer notifiedStatus;

    private String notifierName;

    private String outTitle;

    private static final long serialVersionUID = 1L;

}