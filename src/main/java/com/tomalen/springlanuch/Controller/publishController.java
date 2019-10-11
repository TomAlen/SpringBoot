package com.tomalen.springlanuch.Controller;

import com.tomalen.springlanuch.Cache.tagsCache;
import com.tomalen.springlanuch.DTO.QuestionDTO;
import com.tomalen.springlanuch.Servrice.QuestionService;
import com.tomalen.springlanuch.pojo.Question;
import com.tomalen.springlanuch.pojo.User;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * Author:钟炜宏
 * Date:2019/8/26
 * 发布问题控制器
 */
@Controller
public class publishController {


    @Autowired
    private QuestionService questionService;

    /**
     * 获取更新的数据
     * @param id
     * @return
     */
    @GetMapping("/publish/{id}")
    public String edit(@PathVariable("id")Integer id,
                       Model model) {
        QuestionDTO question = questionService.findById(id);
        model.addAttribute("title",question.getTitle());
        model.addAttribute("description",question.getDescription());
        model.addAttribute("tag",question.getTag());
        model.addAttribute("id",question.getId());
        model.addAttribute("tags", tagsCache.getTags());
        return "publish";
    }

    /**
     * 返回发布页面
     * @return
     */
    @GetMapping("/publish")
    public String publish(Model model) {
        model.addAttribute("tags",tagsCache.getTags());
        return "publish";
    }

    /**
     * 提交表单，返回publish页面
     * @param title
     * @param description
     * @param tag
     * @return
     */
    @PostMapping("/publish")
    public String doPublish(
            @RequestParam(value = "title",required = false)String title,
            @RequestParam(value = "description",required = false)String description,
            @RequestParam(value = "tag",required = false)String tag,
            HttpServletRequest request,
            Model model
    ){
        model.addAttribute("title",title);
        model.addAttribute("description",description);
        model.addAttribute("tag",tag);
        model.addAttribute("tags",tagsCache.getTags());

        if(title == null || title == "") {
            model.addAttribute("error","标题不能为空！");
            return "publish";
        }
        if(description == null || description == "") {
            model.addAttribute("error","补充内容不能为空！");
            return "publish";
        }
        if(tag == null || tag == "") {
            model.addAttribute("error","标签不能为空！");
            return "publish";
        }
        //校检非法tags
        String validTags = tagsCache.validTags(tag);
        //判断非法字符集是否为空
        if(StringUtils.isNotBlank(validTags)) {
            //里面有非法tag
            //返回提问页面
            model.addAttribute("error","非法标签："+validTags);
            return "publish";
        }

        //从登陆会话中拿到user信息
        User user = (User) request.getSession().getAttribute("user");
        //如果user为空，就往model中添加错误信息
        if (user == null) {
            model.addAttribute("error","用户未登录！");
            //回到首页
            return "publish";
        }
        Question question = new Question();
        question.setTag(tag);
        question.setTitle(title);
        question.setDescription(description);
        question.setCreator(user.getId());//把用户id添加进去
        //更新或插入
        questionService.insertOrUpdate(question);
        return "redirect:/";//重定向回首页
    }
}
