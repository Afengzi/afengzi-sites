package com.afengzi.sites.domain.directory;

import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: afengzi
 * Date: 15-3-8
 * Time: 下午10:31
 * To change this template use File | Settings | File Templates.
 */
public class DirectoryMap extends HashMap {

    private long id;
    private String text;

    public DirectoryMap() {

    }

    public DirectoryMap(long id, String text) {
        put(id, text);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
