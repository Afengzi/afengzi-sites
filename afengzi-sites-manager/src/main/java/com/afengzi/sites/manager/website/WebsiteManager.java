package com.afengzi.sites.manager.website;

import com.afengzi.sites.domain.websites.Website;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: afengzi
 * Date: 15-2-7
 * Time: 下午9:37
 * To change this template use File | Settings | File Templates.
 */
public interface WebsiteManager {

    public void addSite(Website website) ;

    public List<Website> getWebsite(String userName) ;
}
