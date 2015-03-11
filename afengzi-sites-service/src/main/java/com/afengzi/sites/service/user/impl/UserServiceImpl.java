package com.afengzi.sites.service.user.impl;

import com.afengzi.sites.domain.Result;
import com.afengzi.sites.domain.user.User;
import com.afengzi.sites.manager.user.UserManager;
import com.afengzi.sites.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * User: afengzi
 * Date: 15-1-18
 * Time: 下午3:17
 * To change this template use File | Settings | File Templates.
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    @Qualifier("userManager")
    private UserManager userManager;

    @Override
    public Result userRegister(String userName, String email, String password) {

        Result result = new Result();
        if (!isRegistrable(userName, email)) {
            return result.setFailedResult("the username or email had been registered.");
        }
        User user = new User();
        user.setUserName(userName);
        user.setEmail(email);
        user.setPassword(password);
        userManager.register(user);
        return result.setSuccessfulResult("registered successful");
    }

    public Result login(String email, String password) {
        User user = userManager.getUserByEmail(email);
        Result result = new Result();
        if (user == null) {
            return result.setFailedResult("用户名不存在");
        }
        if (!user.getPassword().equals(password)) {
            return result.setFailedResult("密码错误");
        }

        return result.setSuccessfulResult("login successful");
    }

    /**
     * 是否可注册
     *
     * @param username
     * @param email
     * @return
     */
    private boolean isRegistrable(String username, String email) {
        return userManager.isRegistrable(username) && userManager.isRegistrable(email);
    }

    @Override
    public boolean isRegisterByName(String userName) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean isRegisterByEmail(String email) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
