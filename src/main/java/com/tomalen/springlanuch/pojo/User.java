package com.tomalen.springlanuch.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * user
 * @author 
 */
@Data
public class User implements Serializable {
    private Integer id;

    private String accountId;

    private String name;

    private String token;

    private Long createTime;

    private Long modifiedTime;

    private String bio;

    private String avatarUrl;

    private static final long serialVersionUID = 1L;


}