package top.qilixiang.examination.controller.login;

import top.qilixiang.examination.model.User;

/**
 * Created by wangzhx on 2018/3/14 17:55
 */
public interface LoginController {

    /**
     * 登录路径
     * @return
     */
    String login();

    /**
     * 登录成功跳转到首页
     * @return
     */
    String index();

    /**
     * 根据账户登录
     * @return
     */
    String loginVerify(String userAccount,String userPwd);

}
