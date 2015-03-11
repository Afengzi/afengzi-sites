package com.afengzi.sites.util;

import com.afengzi.sites.domain.constant.WebsiteConstant;
import com.afengzi.sites.domain.user.User;
import com.google.gson.Gson;
import org.apache.commons.lang.StringUtils;

/**
 * Created with IntelliJ IDEA.
 * User: afengzi
 * Date: 15-1-18
 * Time: 下午2:28
 * To change this template use File | Settings | File Templates.
 */
public class WebsiteUtil {

    public static String getUserKey(User user){
        if (user==null|| StringUtils.isBlank(user.getUserName())||StringUtils.isBlank(user.getEmail())){
            throw new IllegalArgumentException("user is null or userName is blank or email is blank.") ;
        }
        return WebsiteConstant.REDIS_USER_prefix+user.getUserName()+"_"+user.getEmail();
    }

    public static String toGson(Object object){
        Gson gson = new Gson() ;
        return gson.toJson(object) ;
    }

    public static String[] toStringArray(Object object){
        String[] strings = {toGson(object)} ;
        return strings ;
    }
}
