package com.tomalen.springlanuch.Controller;

import com.tomalen.springlanuch.DTO.CommentDTO;
import com.tomalen.springlanuch.DTO.QuestionDTO;
import com.tomalen.springlanuch.Enum.CommentEnumType;
import com.tomalen.springlanuch.Servrice.CommentService;
import com.tomalen.springlanuch.Servrice.QuestionService;
import com.tomalen.springlanuch.pojo.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * Author:钟炜宏
 * Date:2019/8/29
 * 问题列表控制器
 */
@Controller
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @Autowired
    private CommentService commentService;

    @GetMapping("/question/{id}")
    public String getQuestion(@PathVariable("id")Integer id,
                              Model model) {
        QuestionDTO questionDTO = questionService.findById(id);
        //根据问题查出相关问题
        List<QuestionDTO> RelatedQuestion = questionService.selectRelated(questionDTO);


        //获取问题回复列表
        List<CommentDTO> commentDTOS = commentService.listCommentOrQuestionById(id, CommentEnumType.QUESTION);
        //增加阅读数
        questionService.insertCView(id);
        model.addAttribute("question",questionDTO);
        model.addAttribute("comments",commentDTOS);
        model.addAttribute("RelatedQuestion",RelatedQuestion);
        return "question";
    }
}
