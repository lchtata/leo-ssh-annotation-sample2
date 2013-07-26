package edu.leo.action;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;

import edu.leo.common.annotation.EduLeoAnnotation;
import edu.leo.common.framework.CommonAction;
import edu.leo.model.ContactsDetailShowModel;
import edu.leo.service.IContactsDetailShowService;
import edu.leo.value.ContactsInfoValue;

@Scope("prototype")
// @Namespace("/")
@ParentPackage("default")
@EduLeoAnnotation(name = "", loginCheck = true)
@Results({ @Result(name = Action.SUCCESS, location = "/WEB-INF/jsp/contactsDetailShow.jsp") })
public class ContactsDetailShowAction extends CommonAction implements ModelDriven<ContactsDetailShowModel> {

    private static final long serialVersionUID = -2358798343053189384L;

    @Resource
    private ContactsDetailShowModel model;

    @Autowired(required = true)
    public transient IContactsDetailShowService service;

    public ContactsDetailShowModel getModel() {
        return model;
    }

    public String execute() throws Exception {
        log.debug("execute start");

        ContactsInfoValue contactsInfo = service.getDetailInfo(Long.parseLong(model.getContactsSeq()));

        model.setHeaderInfo(contactsInfo.getHeaderInfo());
        model.setPhoneList(contactsInfo.getPhoneList());

        log.debug("execute end");
        return Action.SUCCESS;
    }
}
