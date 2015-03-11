package com.afengzi.sites.controller;


import com.afengzi.sites.domain.directory.DirectoryVo;
import com.afengzi.sites.service.config.CreateFileService;
import com.afengzi.sites.service.sites.WebsiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 15-1-17
 * Time: 上午12:09
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("/")
public class IndexController {
    @Autowired
    @Qualifier("websiteService")
    private WebsiteService websiteService ;
    @Autowired
    @Qualifier("createFileService")
    private CreateFileService createFileService ;

    @RequestMapping(value = "index.do")
    public String index(Model model){
        String name = "xhli";

        model.addAttribute("websites",websiteService.getWebsite(name));
//        createFileService.manualCreateIndexHtml(name);
        return "index" ;
    }
    @RequestMapping("esayui.do")
    public String esayUi(){
        return "esayui";
    }
    @ResponseBody
    @RequestMapping(value = "getDirectory.do", method ={RequestMethod.GET})
    public Object directory(){
        DirectoryVo life = new DirectoryVo();
        life.setId(1);
        life.setText("life");

        DirectoryVo java = new DirectoryVo();
        java.setId(2);
        java.setText("java");

        life.addChild(java);

        DirectoryVo tech = new DirectoryVo();
        tech.setId(3);
        tech.setText("tech");

        List<DirectoryVo> directories = new ArrayList<DirectoryVo>();
        directories.add(life);
        directories.add(tech) ;

        return directories;
    }

}
