package edu.leo.common.framework;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.annotations.After;
import com.opensymphony.xwork2.interceptor.annotations.Before;
import com.opensymphony.xwork2.util.ValueStack;

import edu.leo.common.CommonConst;
import edu.leo.value.LoginInfo;

@Controller
public class CommonAction extends ActionSupport {

    private static final long serialVersionUID = 2539054173371975219L;

    /** Log */
    protected Log log = LogFactory.getLog(this.getClass());

    protected HttpServletRequest getRequest() {
        return ServletActionContext.getRequest();
    }

    protected HttpServletResponse getResponse() {
        return ServletActionContext.getResponse();
    }

    protected HttpSession getSession() {
        return ServletActionContext.getRequest().getSession();
    }

    /**
     * 注意：ActionContext分配context的方式是基于线程的，如果使用这种方法，请确保它不会出错。
     *
     * @return
     */
    protected ValueStack getValueStack() {
        return ActionContext.getContext().getValueStack();
    }

    protected LoginInfo getLoginInfo() {
        LoginInfo loginInfo = null;
        Object loginObject = this.getSession().getAttribute(CommonConst.SESSION_KEY_LOGIN_INFO);
        if (loginObject != null) {
            loginInfo = (LoginInfo) loginObject;
        }
        return loginInfo;
    }

    @Before
    public void beforeMethod() {
        log.info("before: - " + this.getClass().getName());
    }

    @After
    public void afterMethod() {
        ActionInvocation invocation = ActionContext.getContext().getActionInvocation();
        log.info("after: - " + this.getClass().getName() + " Result(" + invocation.getResultCode() + ")");
    }
}
