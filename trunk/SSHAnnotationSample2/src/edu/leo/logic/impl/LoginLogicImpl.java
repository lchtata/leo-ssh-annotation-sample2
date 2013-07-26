package edu.leo.logic.impl;

import java.lang.reflect.InvocationTargetException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.leo.common.util.BeanUtilEx;
import edu.leo.dao.entity.MUser;
import edu.leo.dao.service.IMUserDao;
import edu.leo.logic.ILoginLogic;
import edu.leo.value.LoginInfo;

@Service
public class LoginLogicImpl implements ILoginLogic {

    @Autowired(required = true)
    private IMUserDao userDao;

    // public CommonConst.LoginCheck doLogin(String loginId, String password) {
    // CommonConst.LoginCheck result = CommonConst.LoginCheck.SUCCESS;
    // MUser userEntity = userDao.getDataByLoginIdPwd(loginId, password);
    // if (userEntity == null) {
    // result = CommonConst.LoginCheck.ERROR;
    // }
    // return result;
    // }
    public LoginInfo doLogin(String loginId, String password) throws Exception {
        MUser userEntity = userDao.getDataByLoginIdPwd(loginId, password);
        LoginInfo result = null;
        if (userEntity != null) {
            result = new LoginInfo();
            BeanUtilEx.copyProperties(result, userEntity);
        }
        return result;
    }
}
