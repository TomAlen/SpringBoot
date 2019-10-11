package com.tomalen.springlanuch.DTO;

import lombok.Data;

/**
 * Author:钟炜宏
 * Date:2019/8/25
 * 数传输模型  -->AccessToken模型
 */
@Data
public class AccessTokenDTO {

    //githubAPI第二步： GitHub将用户重定向回您的网站 返回的类型参数
    private String client_id;
    private String client_secret;
    private String code;
    private String redirect_uri;
    private String state;

}
