package edu.leo.service;

import edu.leo.value.LoginInfo;

public interface ILoginService {

    public LoginInfo doLogin(String loginId, String password) throws Exception;
}
