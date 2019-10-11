package com.tomalen.springlanuch.DTO;

import com.tomalen.springlanuch.pojo.User;
import lombok.Data;

/**
 * @author alen zhong
 * @date 19-9-8
 */
@Data
public class NotificationDTO {

    private Integer id;
    private Long gmtCreate;
    private Integer notifier;//评论者
    private String notifierName;
    private Integer status;//状态 已读未读
    private String outTitle;//外部标题
    private String typeName;//通知的类型
    private Integer outerId;//相关联的
    private Integer type;//类型，评论回复/评论问题



}
