package com.afengzi.sites.util;

import com.afengzi.sites.domain.constant.WebsiteConstant;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

/**
 * Created with IntelliJ IDEA.
 * User: afengzi
 * Date: 15-2-7
 * Time: 下午10:57
 * To change this template use File | Settings | File Templates.
 */
public class HttpUtil {

    public static void addCookie(HttpServletResponse response, Cookie cookie) {
        response.addCookie(cookie);
    }

    public static void addCookieAfterLogin(HttpServletResponse response
            , String name) {
        Cookie cookie = new Cookie(WebsiteConstant.USER_NAME_IN_COOKIE,name) ;
        cookie.setDomain("afengzi.com");
        cookie.setPath("/");
        addCookie(response,cookie);
    }
}
