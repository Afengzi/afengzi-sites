package com.afengzi.sites.service.user;

import com.afengzi.sites.domain.Result;

/**
 * Created with IntelliJ IDEA.
 * User: afengzi
 * Date: 15-1-18
 * Time: 下午3:09
 * To change this template use File | Settings | File Templates.
 */
public interface UserService {

    /**
     * 用户注册
     *
     * @param userName
     * @param email
     * @return
     */
    public Result userRegister(String userName, String email, String password);

    /**
     * 用户名是否已被注册
     *
     * @param userName
     * @return
     */
    public boolean isRegisterByName(String userName);

    /**
     * 邮箱是否已被注册
     *
     * @param email
     * @return
     */
    public boolean isRegisterByEmail(String email);

    /**
     * 登陆
     * @param email
     * @param password
     * @return
     */
    public Result login(String email, String password);
}
