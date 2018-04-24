package top.qilixiang.examination.service.login;

import top.qilixiang.examination.model.User;

/**
 * Created by wangzhx on 2018/3/14 17:33
 */
public interface UserService {
    /**
     * 根据帐号查询对应的用户
     * @param userAccount
     * @return
     */
    String loginVerifyService(String userAccount,String userPwd);
}
