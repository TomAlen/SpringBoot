package com.tomalen.springlanuch.Intercepton;

import com.tomalen.springlanuch.Mapper.NotificationMapper;
import com.tomalen.springlanuch.Mapper.UserMapper;
import com.tomalen.springlanuch.Servrice.NotificationService;
import com.tomalen.springlanuch.pojo.User;
import com.tomalen.springlanuch.pojo.UserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Author:钟炜宏
 * Date:2019/8/29
 */
@Service
public class SessionInterceptor implements HandlerInterceptor {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private NotificationService notificationService;

    //在执行前执行拦截器
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //通过Cookie的方式获取user
        Cookie[] cookies = request.getCookies();
        if(cookies != null && cookies.length != 0) {
            for (Cookie cookie : cookies) {
                //如果cookie值与自己定义的值相等，就返回
                if (cookie.getName().equals("token")) {
                    String token = cookie.getValue();
                    //查出user
                    UserExample example = new UserExample();
                    example.createCriteria().andTokenEqualTo(token);
                    List<User> users = userMapper.selectByExample(example);
                    //存入Session
                    if (users.size() != 0) {
                        request.getSession().setAttribute("user", users.get(0));
                        //在登录时先查出通知数，将数字渲染到页面中.
                        Integer unreadCount = notificationService.unreadCount(users.get(0).getId());
                        request.getSession().setAttribute("unreadCount",unreadCount);
                    }
                    break;
                }
            }
        }
        return true;
    }
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
