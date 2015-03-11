package com.afengzi.sites.manager.directory;

import com.afengzi.sites.domain.directory.Directory;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: afengzi
 * Date: 15-3-8
 * Time: 下午10:41
 * To change this template use File | Settings | File Templates.
 */
public interface DirectoryManager {


    public void saveDirectory(Directory directory);

    public List<Directory> queryDirectory(String user);

    public void removeDirectory(long directoryId,String user);

    public void updateDirectory(long directoryId,String user,String text);
}
