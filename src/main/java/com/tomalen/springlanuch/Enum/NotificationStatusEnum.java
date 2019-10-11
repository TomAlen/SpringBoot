package com.tomalen.springlanuch.Enum;

/**
 * @author alen zhong
 * @date 19-9-8
 * 通知的状态枚举类
 */
public enum NotificationStatusEnum {
    UNREAD(0),//未读
    READ(1); //已读

    private int status;

    public int getStatus() {
        return status;
    }

    NotificationStatusEnum(int status) {
        this.status = status;
    }
}
