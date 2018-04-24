package top.qilixiang.examination.service.login.impl;

import com.google.common.base.Strings;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.qilixiang.examination.Constants;
import top.qilixiang.examination.dao.UserMapper;
import top.qilixiang.examination.model.User;
import top.qilixiang.examination.service.login.UserService;

import java.util.Objects;

/**
 * Created by wangzhx on 2018/3/14 17:44
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public String loginVerifyService(String userAccount, String userPwd) {
        if (Strings.isNullOrEmpty(userAccount) || Strings.isNullOrEmpty(userPwd)) {
            log.error("用户帐号，密码不为空");
            throw new RuntimeException();
        }

        User user = userMapper.selectByuUerAccount(userAccount);
        if (Objects.isNull(user)) {
            log.error("该帐号不存在");
            throw new RuntimeException();
        }
        //1.查询用户的信息，根据关联表查询是学生还是老师，是学生转到学生首页，老师调到老师首页
        String md5UserPwd = DigestUtils.md5Hex(userPwd);
        //2.后端将密码md5加密，比对从数据库查询的密码
        if (md5UserPwd.equals(user.getUserPwd())) {
            return Constants.LoginConstants.LOGIN_SUCCESS;
        }
        //3.密码正确，返回login_success，和对应的view，否则返回login_fault
        return Constants.LoginConstants.LOGIN_FAULT;
    }
}
