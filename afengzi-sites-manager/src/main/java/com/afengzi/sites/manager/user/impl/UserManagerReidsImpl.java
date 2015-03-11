package com.afengzi.sites.manager.user.impl;

import com.afengzi.sites.domain.Result;
import com.afengzi.sites.domain.constant.WebsiteConstant;
import com.afengzi.sites.domain.user.User;
import com.afengzi.sites.manager.redis.RedisManager;
import com.afengzi.sites.manager.user.UserManager;
import com.afengzi.sites.util.WebsiteUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

/**
 * Created with IntelliJ IDEA.
 * User: afengzi
 * Date: 15-1-18
 * Time: 上午11:57
 * To change this template use File | Settings | File Templates.
 */
@Service("userManager")
public class UserManagerReidsImpl implements UserManager {

    @Autowired
    @Qualifier("redisManager")
    private RedisManager redisManager;

    @Override
    public boolean register(User user) {
       return redisManager.sadd(WebsiteUtil.getUserKey(user), user);
    }


    @Override
    public boolean isRegistrable(String userNameOrEmail) {
       return redisManager.getUser(userNameOrEmail)==null
               && CollectionUtils.isEmpty(redisManager.getWebsite(userNameOrEmail,1));
    }

    public User getUserByEmail(String email){
        return redisManager.getUser(email);
    }

    public Result isRegister(User user) {
        User dbUser = redisManager.getUser(WebsiteUtil.getUserKey(user));
        Result result = new Result();
        if (dbUser == null) {
            result.put("success", true);
            return result;
        }
        result.put("success", false);
        if (user.getEmail().equals(dbUser.getEmail())) {
            result.put("message", "邮箱已存在");
            if (user.getUserName().equals(dbUser.getUserName())) {
                result.put("message", "邮箱和用户名已存在");
            }
        } else if (user.getUserName().equals(dbUser.getUserName())) {
            result.put("message", "用户名已存在");
        }
        return result;

    }
}
