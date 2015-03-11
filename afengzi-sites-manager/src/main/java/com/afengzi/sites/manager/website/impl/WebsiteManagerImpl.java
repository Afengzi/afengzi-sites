package com.afengzi.sites.manager.website.impl;

import com.afengzi.sites.domain.websites.Website;
import com.afengzi.sites.manager.redis.RedisManager;
import com.afengzi.sites.manager.website.WebsiteManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: afengzi
 * Date: 15-2-7
 * Time: 下午9:38
 * To change this template use File | Settings | File Templates.
 */
@Service("websiteManager")
public class WebsiteManagerImpl implements WebsiteManager {

    @Autowired
    @Qualifier("redisManager")
    private RedisManager redisManager ;
    @Override
    public void addSite(Website website) {
        redisManager.push(website.getUserName(),website);
    }

    public List<Website> getWebsite(String userName){
        return redisManager.getWebsite(userName,-1);
    }
}
