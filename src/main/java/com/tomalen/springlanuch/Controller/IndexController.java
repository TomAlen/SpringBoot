package com.tomalen.springlanuch.Controller;


import com.tomalen.springlanuch.DTO.paginitionDTO;
import com.tomalen.springlanuch.Mapper.QuestionExtMapper;
import com.tomalen.springlanuch.Servrice.QuestionService;
import com.tomalen.springlanuch.pojo.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class IndexController {

    @Autowired
    private QuestionService questionService;

    @Autowired
    private QuestionExtMapper questionExtMapper;

    @GetMapping("/")
    public String index(HttpServletRequest request,
                        Model model,
                        @RequestParam(value = "page",defaultValue = "1")Integer page,
                        @RequestParam(value = "size",defaultValue = "5")Integer size,
                        @RequestParam(value = "search",required = false)String  search) {
        //查出问题信息和用户信息
        paginitionDTO paginitionDTO = questionService.findQuestion(page,size,search);

        //查出阅读量大于15的问题作为热门话题
        List<Question> viewCount = questionExtMapper.selectViewCount();

        //存入Model，交给前端处理
        model.addAttribute("paginition",paginitionDTO);
        model.addAttribute("viewCountList",viewCount);
        //将模糊查询的添加加入
        model.addAttribute("search",search);
        return "index";
    }
}
