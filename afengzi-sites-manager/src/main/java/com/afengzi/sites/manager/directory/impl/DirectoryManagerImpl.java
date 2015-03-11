package com.afengzi.sites.manager.directory.impl;

import com.afengzi.sites.domain.directory.Directory;
import com.afengzi.sites.manager.directory.DirectoryManager;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: afengzi
 * Date: 15-3-8
 * Time: 下午10:45
 * To change this template use File | Settings | File Templates.
 */
@Service("directoryManager")
public class DirectoryManagerImpl implements DirectoryManager {
    @Override
    public void saveDirectory(Directory directory) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<Directory> queryDirectory(String user) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void removeDirectory(long directoryId, String user) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void updateDirectory(long directoryId, String user, String text) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
