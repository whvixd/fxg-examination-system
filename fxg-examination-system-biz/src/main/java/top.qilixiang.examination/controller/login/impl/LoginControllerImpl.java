package top.qilixiang.examination.controller.login.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.qilixiang.examination.controller.login.LoginController;
import top.qilixiang.examination.model.User;
import top.qilixiang.examination.service.login.UserService;

/**
 * Created by wangzhx on 2018/3/14 17:58
 */
@Controller
@RequestMapping(value = "user")
public class LoginControllerImpl implements LoginController {

    @Autowired
    private UserService userService;


    @Override
    @RequestMapping(value = "/login")
    public String login() {
        return "login";
    }

    @Override
    @RequestMapping(value = "/index")
    public String index() {
        return "index";
    }

    @Override
    @RequestMapping(value = "/loginVerify")
    @ResponseBody
    public String loginVerify(String userAccount, String userPwd) {
        return userService.loginVerifyService(userAccount,userPwd);
    }
}
