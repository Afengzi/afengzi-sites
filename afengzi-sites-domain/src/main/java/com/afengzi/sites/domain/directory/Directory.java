package com.afengzi.sites.domain.directory;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: afengzi
 * Date: 15-3-8
 * Time: 下午10:30
 * To change this template use File | Settings | File Templates.
 */
public class Directory {

    private long id;
    private String text;
    private long parent;
    private String user;

    private Date created;
    private String createdPerson;
    private Date modified;
    private String modifiedPerson;

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

    public long getParent() {
        return parent;
    }

    public void setParent(long parent) {
        this.parent = parent;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getCreatedPerson() {
        return createdPerson;
    }

    public void setCreatedPerson(String createdPerson) {
        this.createdPerson = createdPerson;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }

    public String getModifiedPerson() {
        return modifiedPerson;
    }

    public void setModifiedPerson(String modifiedPerson) {
        this.modifiedPerson = modifiedPerson;
    }
}
