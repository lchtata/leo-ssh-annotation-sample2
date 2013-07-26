package edu.leo.logic;

import edu.leo.value.LoginInfo;

public interface ILoginLogic {

    public LoginInfo doLogin(String loginId, String password) throws Exception;
}
