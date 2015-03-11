package com.afengzi.sites.service.sites.impl;

import com.afengzi.sites.domain.websites.Website;
import com.afengzi.sites.manager.website.WebsiteManager;
import com.afengzi.sites.service.sites.WebsiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: afengzi
 * Date: 15-2-8
 * Time: 下午9:45
 * To change this template use File | Settings | File Templates.
 */
@Service("websiteService")
public class WebsiteServiceImpl implements WebsiteService {

    @Autowired
    @Qualifier("websiteManager")
    private WebsiteManager websiteManager;

    @Override
    public List<List<Website>> getWebsite(String userName) {

        List<Website> websites = websiteManager.getWebsite(userName);


        return convertLine(websites);
    }

    private List<List<Website>> convertLine(List<Website> websites) {
        List<List<Website>> rowWebsites = new ArrayList<List<Website>>();
        List<Website> lineWebsite = new ArrayList<Website>();
        for (int i = 1, size = websites.size()+1; i < size; i++) {
            lineWebsite.add(websites.get(i - 1));
            if (i % 3 == 0 || i==size-1) {
                rowWebsites.add(lineWebsite);
                lineWebsite = new ArrayList<Website>();
            }

        }

        return rowWebsites;
    }
}
