package com.afengzi.sites.manager;

import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: afengzi
 * Date: 15-1-18
 * Time: 下午12:49
 * To change this template use File | Settings | File Templates.
 */
public class RedisT {


    @Test
    public void sadd() {
        Jedis jedis = connection();

        jedis.sadd("klov", "{id:1,href:baidu.com}");
        jedis.sadd("klov", "{id:2,href:jd.com}");
    }

    @Test
    public void smembers() {
        Jedis jedis = connection();
        Set<String> urls = jedis.smembers("klov");
        System.out.print("*************** : " + urls);
    }

    private Jedis connection() {
        Jedis jedis = new Jedis("sites.afengzi.com", 6379);
        return jedis;
    }

}
