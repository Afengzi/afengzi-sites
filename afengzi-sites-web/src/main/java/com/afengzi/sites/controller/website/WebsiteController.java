package com.afengzi.sites.controller.website;

import com.afengzi.sites.domain.directory.DirectoryVo;
import com.afengzi.sites.domain.websites.Website;
import com.afengzi.sites.manager.website.WebsiteManager;
import com.afengzi.sites.util.HttpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: afengzi
 * Date: 15-2-7
 * Time: 下午9:34
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("/site/")
public class WebsiteController {
    @Autowired
    @Qualifier("websiteManager")
    private WebsiteManager websiteManager;

    @ResponseBody
    @RequestMapping(value = "addSite.do", method ={RequestMethod.POST,RequestMethod.GET})
    public String addSite(HttpServletResponse response,String title, String url, String description) {
        Website website = new Website();
        website.setUserName("xhli");
        website.setTitle(title);
        website.setHref(url);
        website.setDescription(description);
        websiteManager.addSite(website);
        HttpUtil.addCookieAfterLogin(response,"klov");
        return "success";
    }
    @ResponseBody
    @RequestMapping(value = "directory.do", method ={RequestMethod.GET})
    public Object getDirectory(HttpServletResponse response,String title, String url, String description) {
        DirectoryVo directory = new DirectoryVo();
        Map<String,String> map = new HashMap<String, String>();
        map.put("1","life")  ;
        map.put("2","tech")  ;
        return map;
    }
}
