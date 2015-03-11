package com.afengzi.sites.domain.directory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: afengzi
 * Date: 15-3-8
 * Time: 下午5:40
 * To change this template use File | Settings | File Templates.
 */
public class DirectoryVo {
    private long id ;
    private int status;
    private String text ;
    private List<DirectoryVo> children ;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<DirectoryVo> getChildren() {
        return children;
    }

    public void setChildren(List<DirectoryVo> children) {
        this.children = children;
    }

    public void addChild(DirectoryVo child){
       if (children==null){
           children = new ArrayList<DirectoryVo>();
       }
        children.add(child);
    }
}
