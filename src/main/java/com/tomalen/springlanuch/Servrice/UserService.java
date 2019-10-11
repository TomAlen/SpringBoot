package com.tomalen.springlanuch.Servrice;

import com.tomalen.springlanuch.Mapper.UserMapper;
import com.tomalen.springlanuch.pojo.User;
import com.tomalen.springlanuch.pojo.UserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author:钟炜宏
 * Date:2019/8/29
 * 用户的业务层
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 根据情况更新或者插入用户信息
     * @param user
     */
    public void insertOrUpdateUser(User user) {
        //根据accountId查找用户
        UserExample example = new UserExample();
        example.createCriteria().andAccountIdEqualTo(user.getAccountId());
        List<User> users = userMapper.selectByExample(example);
        if(users.size() == 0) {
            //插入
            user.setCreateTime(System.currentTimeMillis());//当前的时间
            user.setModifiedTime(user.getCreateTime());
            userMapper.insert(user);
        }else{
            //更新
            User updateUser = new User();

            updateUser.setName(user.getName());
            updateUser.setAvatarUrl(user.getAvatarUrl());
            updateUser.setModifiedTime(System.currentTimeMillis());
            updateUser.setToken(user.getToken());
            //构造sql
            UserExample userExample = new UserExample();
            userExample.createCriteria()
                    .andIdEqualTo(users.get(0).getId());//拿到第一个user的id，进行更新
            userMapper.updateByExampleSelective(updateUser,userExample);
        }
    }
}
