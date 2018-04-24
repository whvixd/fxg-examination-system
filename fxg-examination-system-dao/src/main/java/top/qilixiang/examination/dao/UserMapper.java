package top.qilixiang.examination.dao;

import org.springframework.stereotype.Repository;
import top.qilixiang.examination.model.User;

@Repository
public interface UserMapper {
    int deleteByPrimaryKey(String id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String id);

    User selectByuUerAccount(String userAcount);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}