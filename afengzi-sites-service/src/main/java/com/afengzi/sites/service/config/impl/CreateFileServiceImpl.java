package com.afengzi.sites.service.config.impl;

import com.afengzi.sites.domain.websites.Website;
import com.afengzi.sites.service.sites.WebsiteService;
import com.afengzi.sites.service.config.CreateFileService;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.context.ServletContextAware;

import javax.servlet.ServletContext;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: afengzi
 * Date: 15-2-25
 * Time: 下午8:22
 * To change this template use File | Settings | File Templates.
 */
public class CreateFileServiceImpl implements CreateFileService,ServletContextAware {
    private static final Logger logger = Logger.getLogger(CreateFileServiceImpl.class);
    //首页模板路径
    private String templateDirectoryPath;
    //首页保存路径
    private String indexHtmlPath;

    @Autowired
    @Qualifier("websiteService")
    private WebsiteService websiteService ;

    @Override
    public void manualCreateIndexHtml(String userPin) {
        List<List<Website>> data = websiteService.getWebsite(userPin) ;
        if (data==null||data.isEmpty()){
            logger.info("manualCreateIndexHtml error. data is empty,the user:"+userPin);
            return;
        }
        Map<String,Object> content = new HashMap<String, Object>();
        content.put("websites",data);
        createPage("/WEB-INF/vm/index.vm", indexHtmlPath, content);
    }

    private void createPage(String templateName, String pageName, Map<String, Object> dataMap) {
        PrintWriter writer = null;
        try {
            VelocityEngine engine = new VelocityEngine();
            engine.setProperty(Velocity.FILE_RESOURCE_LOADER_PATH, templateDirectoryPath);
            engine.init();

            Template template = engine.getTemplate(templateName, "utf-8");
            writer = new PrintWriter(pageName);
            template.merge(getVelocityContext(dataMap), writer);
            writer.flush();
            writer.close();
        } catch (Exception e) {
            logger.error("初始化模板引擎异常.", e);

        } finally {
            if (writer != null) {
                writer.close();
            }
        }

    }

    private VelocityContext getVelocityContext(Map<String, Object> dataMap) {
        VelocityContext velocityContext = new VelocityContext();
        for (Map.Entry entry : dataMap.entrySet()) {
            velocityContext.put(String.valueOf(entry.getKey()), entry.getValue());
        }
        return velocityContext;


    }

    /**
     * ****************setter********************
     */

    public void setIndexHtmlPath(String indexHtmlPath) {
        this.indexHtmlPath = indexHtmlPath;
    }

    public void setWebsiteService(WebsiteService websiteService) {
        this.websiteService = websiteService;
    }

    @Override
    public void setServletContext(ServletContext servletContext) {
        templateDirectoryPath = servletContext.getRealPath("/");
        logger.info("***template directory Path : "+ templateDirectoryPath);
    }
}
