package com.afengzi.sites.service.sites;

import com.afengzi.sites.domain.websites.Website;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: afengzi
 * Date: 15-2-8
 * Time: 下午9:44
 * To change this template use File | Settings | File Templates.
 */
public interface WebsiteService {
    public List<List<Website>> getWebsite(String userName) ;
}
