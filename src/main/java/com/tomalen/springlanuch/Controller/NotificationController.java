package com.tomalen.springlanuch.Controller;

import com.tomalen.springlanuch.DTO.NotificationDTO;
import com.tomalen.springlanuch.Enum.NotificationTypeEnum;
import com.tomalen.springlanuch.Servrice.NotificationService;
import com.tomalen.springlanuch.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;

/**
 * @author alen zhong
 * @date 19-9-8
 */
@Controller
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @GetMapping("/notification/{id}")
    public String profile(@PathVariable(name = "id") Integer id,
                          HttpServletRequest request, Model model) {
        //从登陆会话中拿到user信息
        User user = (User) request.getSession().getAttribute("user");
        //如果user为空，就往model中添加错误信息
        if (user == null) {
            model.addAttribute("error", "用户未登录！");
            //回到首页
            return "redirect:/";
        }

        //校检通知
        NotificationDTO notificationDTO = notificationService.readNotified(id, user);
        //跳转
        if (notificationDTO.getType() == NotificationTypeEnum.REPLY_COMMENT.getType()
                || notificationDTO.getType() == NotificationTypeEnum.REPLY_QUESTION.getType()) {
            //跳转到相关问题的页面
            return "redirect:/question/" + notificationDTO.getOuterId();
        } else {
            return "redirect:/";
        }

    }
}