package edu.leo.action;

import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.context.annotation.Scope;

import com.opensymphony.xwork2.Action;

import edu.leo.common.annotation.EduLeoAnnotation;
import edu.leo.common.framework.CommonAction;

@Scope("prototype")
// @Namespace("/")
@ParentPackage("default")
@EduLeoAnnotation(name = "", loginCheck = true)
@Results({ @Result(name = Action.SUCCESS, location = "/WEB-INF/jsp/main.jsp") })
public class MainAction extends CommonAction {

    private static final long serialVersionUID = 4195559157720346469L;

    public String execute() throws Exception {
        log.debug("execute start");

        log.debug("execute end");
        return Action.SUCCESS;
    }
}
