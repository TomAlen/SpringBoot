package com.tomalen.springlanuch.Mapper;

import com.tomalen.springlanuch.DTO.SearchByQuery;
import com.tomalen.springlanuch.pojo.Question;

import java.util.List;

/**
 * Author:钟炜宏
 * Date:2019/8/31
 */
public interface QuestionExtMapper {
    int incViewCount(Question record);
    int incCommentCount(Question record);
    List<Question> selectByRelated(Question question);
    Integer countBySearch(SearchByQuery searchByQuery);
    List<Question> selectBySearch(SearchByQuery searchByQuery);
    List<Question> selectViewCount();//查出热门话题
}
