package edu.leo.common.interceptor;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
import com.opensymphony.xwork2.util.ValueStack;

import edu.leo.common.CommonConst;
import edu.leo.common.annotation.EduLeoAnnotation;
import edu.leo.value.ResponseResultValue;

public class LoginInterceptor extends MethodFilterInterceptor {

    private static final long serialVersionUID = -4484594118478257487L;

    /** see struts.xml */
    private static final String LOGIN_FORWARD = "loginfw";

    @Override
    public String doIntercept(ActionInvocation invocation) throws Exception {
        // Actionに設定されているアノテーション情報を取得する。
        Class<?> actionClass = invocation.getAction().getClass();

        // String targetMethodName = invocation.getProxy().getMethod();
        // Method targetMethod = actionClass.getMethod(targetMethodName,
        // (Class[]) null);

        EduLeoAnnotation loginAnn = (EduLeoAnnotation) actionClass.getAnnotation(EduLeoAnnotation.class);

        boolean isLoginCheck = true;

        if (loginAnn == null || loginAnn.loginCheck()) {
            isLoginCheck = true;
        } else {
            isLoginCheck = false;
        }

        if (isLoginCheck) {
            HttpSession session = ServletActionContext.getRequest().getSession();
            Object loginInfo = session.getAttribute(CommonConst.SESSION_KEY_LOGIN_INFO);
            if (loginInfo == null) {
                log.info("■did not login . forward to login page!!■");
                // set error message.
                ResponseResultValue rstValue = new ResponseResultValue();
                rstValue.setResultMsg("please login..........");
                ValueStack stack = invocation.getStack();
                stack.push(rstValue);
                return LOGIN_FORWARD;
            } else {
            }
        }

        return invocation.invoke();
    }

}
