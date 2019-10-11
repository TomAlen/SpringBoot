package com.tomalen.springlanuch.provider;

import com.alibaba.fastjson.JSON;
import com.tomalen.springlanuch.DTO.AccessTokenDTO;
import com.tomalen.springlanuch.DTO.GithubUser;
import okhttp3.*;
import org.springframework.stereotype.Component;

/**
 * Author:钟炜宏
 * Date:2019/8/25
 *
 */
@Component
public class GithubProvider {

    /**
     * 第一步、
     * 得到AccessToken
     * @param accessTokenDTO
     * @return
     */
    public String getAccessToken(AccessTokenDTO accessTokenDTO){
         MediaType mediaType = MediaType.get("application/json; charset=utf-8");
         OkHttpClient client = new OkHttpClient();
         //把MediaType对象解析成srting类型
            RequestBody body = RequestBody.create(mediaType,JSON.toJSONString(accessTokenDTO));
            Request request = new Request.Builder()
                    //github重定向个人网站url，交换access_token
                .url("https://github.com/login/oauth/access_token")
                .post(body)
                .build();
            try (Response response = client.newCall(request).execute()) {
                //得到返回的access_token
                String string = response.body().string();
                //拆分得到access_token
                //先以&号拆分，后以=号拆分
                String[] split = string.split("&");
                String tokenString = split[0];
                String access_token = tokenString.split("=")[1];
                return access_token;
            }catch (Exception e){
                e.printStackTrace();
            }
            return null;
    }

    /**
     * 把得到的accessToken传入User对象，得到user对象的信息
     * 得到返回的Scope的User信息
     * 定义的githubUser有三个属性
     * @param accessToken
     * @return
     */
    public GithubUser githubUser(String accessToken) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://api.github.com/user?access_token=" + accessToken)
                .build();
        try{
            Response response = client.newCall(request).execute();
            String string = response.body().string();
            //把得到的从url得到的json数据解析成GithubUser类对象
            GithubUser githubUser = JSON.parseObject(string, GithubUser.class);
            return githubUser;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
