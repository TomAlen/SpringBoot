package com.tomalen.springlanuch.DTO;

import lombok.Data;

/**
 * @author alen zhong
 * @date 19-9-13
 */
@Data
public class SearchByQuery {
    private String search;
    private Long page;
    private Integer size;
}
