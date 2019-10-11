package com.tomalen.springlanuch.Controller;

import com.tomalen.springlanuch.DTO.paginitionDTO;
import com.tomalen.springlanuch.Servrice.NotificationService;
import com.tomalen.springlanuch.Servrice.QuestionService;
import com.tomalen.springlanuch.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * Author:钟炜宏
 * Date:2019/8/28
 * 我的问题控制器
 */
@Controller
public class ProController {

    @Autowired
    private QuestionService questionService;

    @Autowired
    private NotificationService notificationService;


    /**
     * 路径，后面加一个动态动作。可以动态路由控制请求。
     *
     * @param action url  相当于动态url
     * @param model
     * @return
     */
    @GetMapping("/profile/{action}")
    public String profile(@PathVariable(name = "action") String action,
                          Model model,
                          HttpServletRequest request,
                          @RequestParam(value = "page", defaultValue = "1") Integer page,
                          @RequestParam(value = "size", defaultValue = "5") Integer size) {
        //从登陆会话中拿到user信息
        User user = (User) request.getSession().getAttribute("user");
        //如果user为空，就往model中添加错误信息
        if (user == null) {
            model.addAttribute("error", "用户未登录！");
            //回到首页
            return "redirect:/";
        }
        //发送的请求参数为questions
        if ("questions".equals(action)) {
            model.addAttribute("section", "questions");
            model.addAttribute("sectionName", "我的提问");
            //通过service层获取用户提问的分页信息
            paginitionDTO paginitionDTO = questionService.list(user.getId(), page, size);
            Integer countByQuestion = questionService.findCount(user.getId());
            model.addAttribute("countByQuestion",countByQuestion);
            //存入Model，交给前端处理
            model.addAttribute("paginition", paginitionDTO);
        } else if ("replies".equals(action)) { //最新回复
            paginitionDTO paginitionDTO = notificationService.list(user.getId(), page, size);
            //Integer unreadCount = notificationService.unreadCount(user.getId());
            model.addAttribute("section", "replies");
            model.addAttribute("sectionName", "最新回复");
           //model.addAttribute("unreadCount",unreadCount);
            model.addAttribute("paginition",paginitionDTO);
        }

        return "profile";
    }
}
