package com.afengzi.sites.controller.user;

import com.afengzi.sites.domain.Result;
import com.afengzi.sites.service.user.UserService;
import com.afengzi.sites.util.HttpUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created with IntelliJ IDEA.
 * User: afengzi
 * Date: 15-1-18
 * Time: 下午3:07
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("/user/")
public class UserController {

    @Autowired
    @Qualifier("userService")
    private UserService userService;

    @RequestMapping("register.do")
    public String register(Model model, @RequestParam(value = "username") String userName,@Validated() String email, String password) {
        if (StringUtils.isBlank(userName) || StringUtils.isBlank(email)) {
            model.addAttribute("message", "用户名或密码为空");
        }
        Result result = userService.userRegister(userName, email, password);
        if (result.isSuccess()) {
            model.addAttribute("message", "注册成功");
        } else {
            model.addAttribute("message", result.getFailedMessage());
        }
        return "user-message";
    }
    @RequestMapping("toRegister.do")
    public String toRegister(Model model){
        return "register" ;
    }
    @RequestMapping("login.do")//name ="login.do",value = "/returnUrl={returnUrl}")
    public String doLogin(@PathVariable("returnUrl")String returnUrl,HttpServletRequest request,HttpServletResponse response,String email,String password){
        Result result = userService.login(email,password);
        if (result.isSuccess()){
            HttpUtil.addCookieAfterLogin(response,email);
        }
        return "redirect:/"+returnUrl ;
    }


    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
