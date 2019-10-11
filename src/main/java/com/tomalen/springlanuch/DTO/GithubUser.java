package com.tomalen.springlanuch.DTO;

import lombok.Data;

/**
 * Author:钟炜宏
 * Date:2019/8/25
 * 数据传输转换模型-->返回User的实体类对象
 */
@Data
public class GithubUser {

    //github的姓名
    private String name;
    //id
    private Long id;
    //描述
    private String bio;
    //github头像
    private String avatarUrl;

}
