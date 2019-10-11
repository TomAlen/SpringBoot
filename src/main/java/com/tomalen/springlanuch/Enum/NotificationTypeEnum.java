package com.tomalen.springlanuch.Enum;

/**
 * @author alen zhong
 * @date 19-9-8
 * 通知的类型枚举类
 */
public enum NotificationTypeEnum {
    REPLY_QUESTION(1,"回复了问题"),
    REPLY_COMMENT(2,"回复了评论")
    ;

    private int type;  //通知的类型  回复/评论

    private String name;

    public int getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    NotificationTypeEnum(int type, String name) {
        this.type = type;
        this.name = name;
    }

    //判断传入的类型是否为本类型，将类型值返回
    public static String nameOfType(int type) {
        for (NotificationTypeEnum typeEnum : NotificationTypeEnum.values()) {
            if(typeEnum.type == type) {
                return typeEnum.name;
            }

        }
        //不存在直接抛出空字符串
        return "";
    }


}
