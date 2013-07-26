package edu.leo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.leo.logic.ILoginLogic;
import edu.leo.service.ILoginService;
import edu.leo.value.LoginInfo;

@Service
public class LoginServiceImpl implements ILoginService {

    @Autowired(required = true)
    private ILoginLogic loginLogic;

    // @Transactional(readOnly = false, rollbackFor = Throwable.class)
    @Transactional(readOnly = true)
    public LoginInfo doLogin(String loginId, String password) throws Exception {
        return loginLogic.doLogin(loginId, password);
    }
}
