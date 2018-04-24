package top.qilixiang.examination.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String id;

    private String userAccount;

    private String userPwd;

    private String userIdcard;

    private String userName;

    private String userSex;

    private String userNickname;

    private String userStatusId;

    private String userEmail;

    private String userQq;

    private String userTelphone;

    private Date userCreatedate;

    private String userSchoolId;

    private String userDegree;

    private String userBirth;

    private String userProvinceId;

    private String userType;

    private String userPersonId;

    private String firstLog;

    private String userSchoolPrvo;


}