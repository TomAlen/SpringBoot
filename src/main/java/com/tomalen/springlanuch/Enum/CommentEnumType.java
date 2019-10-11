package com.tomalen.springlanuch.Enum;

/**
 * Author:钟炜宏
 * Date:2019/8/31
 */
public enum CommentEnumType {
    //1：代表提问
    QUESTION(1),
    //2代表回复
    COMMENT(2);

    private Integer type;

    CommentEnumType(Integer type) {
        this.type = type;
    }

    public static boolean isExist(Integer type) {
        //对类型进行foreach循环
        for (CommentEnumType enumType : CommentEnumType.values()) {
            //如果相等就返回true
            if(enumType.getType() == type) {
                return true;
            }
        }
        return false;
    }

    public Integer getType() {
        return type;
    }

}
