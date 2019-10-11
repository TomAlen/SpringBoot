package com.tomalen.springlanuch.DTO;

import lombok.Data;

import java.util.List;

/**
 * @author alen zhong
 * @date 19-9-7
 */
@Data
public class TagCacheDTO {

    //便签的分类
    private String categoryTag;

    //分类的子标签
    private List<String> tags;


}
