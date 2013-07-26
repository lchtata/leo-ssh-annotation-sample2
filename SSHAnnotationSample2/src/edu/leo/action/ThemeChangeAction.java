package edu.leo.action;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.context.annotation.Scope;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;

import edu.leo.common.CommonConst;
import edu.leo.common.annotation.EduLeoAnnotation;
import edu.leo.common.framework.CommonAction;
import edu.leo.model.ThemeChangeModel;

@Scope("prototype")
// @Namespace("/")
@ParentPackage("default")
@EduLeoAnnotation(name = "", loginCheck = true)
@Results({ @Result(name = Action.SUCCESS, type = "redirectAction", location = "${nowPageUrl}") })
public class ThemeChangeAction extends CommonAction implements ModelDriven<ThemeChangeModel> {

    private static final long serialVersionUID = 8719436778826291668L;

    @Resource
    private ThemeChangeModel model;

    public ThemeChangeModel getModel() {
        return model;
    }

    public String execute() throws Exception {
        log.debug("execute start");

        if (StringUtils.isEmpty(model.getThemeName())) {
            model.setThemeName(CommonConst.THEME_DEFAULT);
        }

//        String nowPageUrl = model.getNowPageUrl();
//        nowPageUrl = nowPageUrl.substring(nowPageUrl.lastIndexOf("/") + 1);
//        if (nowPageUrl.equals("login!login.action")) {
//            nowPageUrl = "main.action";
//        }
//        model.setNowPageUrl(nowPageUrl);
        model.setNowPageUrl("main.action");

        getSession().setAttribute(CommonConst.SESSION_KEY_THEME, model.getThemeName());

        log.debug("execute end");
        return Action.SUCCESS;
    }
}
