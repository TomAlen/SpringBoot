package com.tomalen.springlanuch.Controller;

import com.tomalen.springlanuch.DTO.AccessTokenDTO;
import com.tomalen.springlanuch.DTO.GithubUser;
import com.tomalen.springlanuch.Servrice.UserService;
import com.tomalen.springlanuch.pojo.User;
import com.tomalen.springlanuch.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * Author:钟炜宏
 * Date:2019/8/25
 * github登录控制器
 */
@Controller
public class AuthorizeController {

    @Autowired
    private GithubProvider githubProvider;

    @Autowired
    private UserService userService;


    //从配置文件中读取数据
    @Value("${github.client.id}")
    private String ClientId;

    @Value("${github.client.secret}")
    private String ClientSecret;

    @Value("${github.redirect.url}")
    private String redirect_url;



    /**
     * 登录操作回调
     * 授权github返回主页面
     * 获取accessToken
     * @param code
     * @param state
     * @return
     */
    @GetMapping("/callback")
    public String callback(@RequestParam(name = "code")String code,
                           @RequestParam(name = "state")String state,
                           HttpServletRequest request,
                           HttpServletResponse response) {
        //实例化AccessTokenDTO
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setCode(code);
        accessTokenDTO.setRedirect_uri(redirect_url);
        accessTokenDTO.setClient_id(ClientId);
        accessTokenDTO.setState(state);
        accessTokenDTO.setClient_secret(ClientSecret);
        String accessToken = githubProvider.getAccessToken(accessTokenDTO);
        //得到Github User信息
        GithubUser githubUser = githubProvider.githubUser(accessToken);
        //登录成功
        if(githubUser != null && githubUser.getId() != null){
            //插入User信息进数据库
            User user = new User();
            String token = UUID.randomUUID().toString();
            user.setToken(token);
            user.setName(githubUser.getName());
            user.setAccountId(String.valueOf(githubUser.getId()));
            user.setBio(githubUser.getBio());
            user.setAvatarUrl(githubUser.getAvatarUrl());
            userService.insertOrUpdateUser(user);
            //自定义Cookie，生成登录令牌，写入cookie
            response.addCookie(new Cookie("token",token));
            //重定向登录页面
            return "redirect:/";
        }else{
            //登录失败，重新登录
            return "redirect:/";
        }
    }

    /**
     * 登出功能
     * @param request
     * @param response
     * @return
     */
    @GetMapping("/logout")
    public String logout(HttpServletRequest request,HttpServletResponse response) {
        //消除session
        request.getSession().setAttribute("user",null);
        //消除cookie
        Cookie cookie = new Cookie("token",null);
        cookie.setMaxAge(0);
        response.addCookie(cookie);
        return "redirect:/";
    }

}
