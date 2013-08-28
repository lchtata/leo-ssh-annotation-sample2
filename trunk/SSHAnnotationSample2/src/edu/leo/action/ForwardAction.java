package edu.leo.action;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.context.annotation.Scope;

import com.opensymphony.xwork2.ModelDriven;

import edu.leo.common.annotation.EduLeoAnnotation;
import edu.leo.common.framework.CommonAction;
import edu.leo.model.ForwardModel;

@Scope("prototype")
// @Namespace("/")
@ParentPackage("default")
@EduLeoAnnotation(name = "", loginCheck = true)
@Results({ @Result(name = "welcome", location = "/WEB-INF/jsp/login.jsp"),
    @Result(name = "gotoCalendar", location = "/WEB-INF/jsp/calendar.jsp") })
public class ForwardAction extends CommonAction implements ModelDriven<ForwardModel> {

    private static final long serialVersionUID = 7589180119471737353L;

    @Resource
    private ForwardModel model;

    public ForwardModel getModel() {
        return model;
    }

    public String execute() throws Exception {
        log.debug("execute start");

        log.debug("execute end");
        return "welcome";
    }

    public String gotoCalendar() throws Exception {
        log.debug("gotoCalendar start");

        log.debug("gotoCalendar end");
        return "gotoCalendar";
    }
}
