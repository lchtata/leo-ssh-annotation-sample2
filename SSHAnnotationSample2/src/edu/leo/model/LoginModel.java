package edu.leo.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import edu.leo.common.framework.CommonModel;

@Scope("request")
@Controller
public class LoginModel extends CommonModel {

    private static final long serialVersionUID = -7615229287934062786L;

    private String loginId;
    private String password;

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
