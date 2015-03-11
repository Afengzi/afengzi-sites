package com.afengzi.sites.manager.redis.impl;

import com.afengzi.sites.domain.user.User;
import com.afengzi.sites.domain.websites.Website;
import com.afengzi.sites.manager.redis.RedisManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: afengzi
 * Date: 15-1-18
 * Time: 下午1:52
 * To change this template use File | Settings | File Templates.
 */
@Service("redisManager")
public class RedisManagerImpl extends RedisTemplate implements RedisManager {


    @Override
    public boolean sadd(String key, Object... objects) {
        SetOperations setOperations = super.opsForSet();
        Long count = setOperations.add(key, objects);
        return count != null && count.intValue() > 0;
    }

    public boolean push(String key, Object... objects) {
        ListOperations listOperations = super.opsForList();
        Long count = listOperations.leftPushAll(key, objects);
        return count != null && count.intValue() > 0;
    }

    public User getUser(String email) {
        ValueOperations<String, User> userValue = super.opsForValue();
        return userValue.get(email);
    }

    public List<Website> getWebsite(String username, int count) {
        if (count < 0) {
            count = -1;
        }
        ListOperations<String, Website> websites = super.opsForList();
        return websites.range(username, 0, count);
    }


    /**
     * ************setter and getter********************
     */


    @Autowired()
    @Qualifier("jedisConnectionFactory")
    @Override
    public void setConnectionFactory(RedisConnectionFactory connectionFactory) {
        super.setConnectionFactory(connectionFactory);    //To change body of overridden methods use File | Settings | File Templates.
    }
}
