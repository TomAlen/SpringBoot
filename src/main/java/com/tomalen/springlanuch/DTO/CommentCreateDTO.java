package com.tomalen.springlanuch.DTO;

import lombok.Data;

/**
 * Author:钟炜宏
 * Date:2019/8/31
 */
@Data
public class CommentCreateDTO {

    private Integer parentId;
    private String content;
    private Integer type;

}
