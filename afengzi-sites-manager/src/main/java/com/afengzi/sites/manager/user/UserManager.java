package com.afengzi.sites.manager.user;

import com.afengzi.sites.domain.user.User;

/**
 * Created with IntelliJ IDEA.
 * User: afengzi
 * Date: 15-1-18
 * Time: 上午11:49
 * To change this template use File | Settings | File Templates.
 */
public interface UserManager {

    /**
     * 注册用户
     * @param user
     */
    public boolean register(User user) ;

    /**
     * 用户名or密码是否可注册
     * @param userNameOrEmail
     * @return
     */
    public boolean isRegistrable(String userNameOrEmail) ;

    /**
     * 根据email获取用户信息
     * @param email
     * @return
     */
    public User getUserByEmail(String email) ;
}
