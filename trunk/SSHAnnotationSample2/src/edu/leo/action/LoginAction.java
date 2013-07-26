package edu.leo.action;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;

import edu.leo.common.CommonConst;
import edu.leo.common.annotation.EduLeoAnnotation;
import edu.leo.common.framework.CommonAction;
import edu.leo.model.LoginModel;
import edu.leo.service.ILoginService;
import edu.leo.value.LoginInfo;

@Scope("prototype")
// @Namespace("/")
@ParentPackage("default")
@EduLeoAnnotation(name = "", loginCheck = false)
@Results({ @Result(name = "welcome", location = "/WEB-INF/jsp/login.jsp"), @Result(name = Action.SUCCESS, type = "chain", location = "main") })
public class LoginAction extends CommonAction implements ModelDriven<LoginModel> {

    private static final long serialVersionUID = 1699636850099354209L;

    @Resource
    private LoginModel model;

    public LoginModel getModel() {
        return model;
    }

    @Autowired(required = true)
    private ILoginService service;

    public String execute() throws Exception {
        log.debug("execute start");

        this.setLogoutSesstionAtrribute();

        log.debug("execute end");
        return "welcome";
    }

    public String login() throws Exception {
        log.debug("login start");

        String forward = null;

        String loginId = model.getLoginId();
        String password = model.getPassword();

        // CommonConst.LoginCheck result = service.doLogin(loginId, password);
        LoginInfo loginInfo = service.doLogin(loginId, password);
        if (loginInfo != null) {
            forward = SUCCESS;

            this.setLoginSesstionAtrribute(loginInfo);

            log.info("login sucess");
        } else {
            forward = "welcome";
            String msg = getText("error.login_failed");
            super.addActionError(msg);
            this.setLogoutSesstionAtrribute();

            log.info("login error");
        }

        log.debug("login end");
        return forward;
    }

    public String logout() throws Exception {
        log.debug("logout start");

        this.setLogoutSesstionAtrribute();

        log.debug("logout end");
        return "welcome";
    }

    private void setLoginSesstionAtrribute(LoginInfo loginInfo) {
        super.getSession().setAttribute(CommonConst.SESSION_KEY_LOGIN_INFO, loginInfo);
        super.getSession().setAttribute(CommonConst.SESSION_KEY_THEME, CommonConst.THEME_DEFAULT);
    }

    private void setLogoutSesstionAtrribute() {
        super.getSession().removeAttribute(CommonConst.SESSION_KEY_LOGIN_INFO);
        super.getSession().removeAttribute(CommonConst.SESSION_KEY_THEME);
    }
}
