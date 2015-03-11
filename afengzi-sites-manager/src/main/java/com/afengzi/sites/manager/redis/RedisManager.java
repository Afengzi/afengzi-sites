package com.afengzi.sites.manager.redis;

import com.afengzi.sites.domain.user.User;
import com.afengzi.sites.domain.websites.Website;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: afengzi
 * Date: 15-1-18
 * Time: 下午12:25
 * To change this template use File | Settings | File Templates.
 */
public interface RedisManager {

    public boolean sadd(String key, Object... objects);

    /**
     * 根据email获取用户信息
     * @param email
     * @return
     */
    public User getUser(String email) ;

    /**
     * 获取该用户最新的count条记录
     * @param username
     * @return
     */
    public List<Website> getWebsite(String username,int count) ;

    public boolean push(String key, Object... objects);
}
