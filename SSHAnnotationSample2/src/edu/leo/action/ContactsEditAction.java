package edu.leo.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;

import edu.leo.common.CommonConst;
import edu.leo.common.annotation.EduLeoAnnotation;
import edu.leo.common.exception.SSHSampleException;
import edu.leo.common.framework.CommonAction;
import edu.leo.common.util.BeanUtilEx;
import edu.leo.model.ContactsEditModel;
import edu.leo.service.IContactsEditService;
import edu.leo.value.ContactsInfoValue;
import edu.leo.value.LoginInfo;
import edu.leo.value.TContactsHeaderValue;
import edu.leo.value.TContactsPhoneValue;

@Scope("prototype")
// @Namespace("/")
@ParentPackage("default")
@EduLeoAnnotation(name = "", loginCheck = true)
@Results({ @Result(name = "welcome", location = "/WEB-INF/jsp/contactsEdit.jsp"), @Result(name = Action.SUCCESS, location = "/WEB-INF/jsp/result.jsp") })
public class ContactsEditAction extends CommonAction implements ModelDriven<ContactsEditModel> {

    private static final long serialVersionUID = -6890936653702906925L;

    @Resource
    private ContactsEditModel model;

    @Autowired(required = true)
    public transient IContactsEditService service;

    public ContactsEditModel getModel() {
        return model;
    }

    public String execute() throws Exception {
        log.debug("execute start");

        String actionType = model.getAcctionType();

        if (CommonConst.ACTION_TYPE_NEW.equals(actionType)) {
            // new mode

            model.setContactsSeq("New");

        } else {
            // edit mode

            this.search();
        }

        log.debug("execute end");
        return "welcome";
    }

    private void search() throws Exception {
        log.debug("search start");

        String contactsSeq = model.getContactsSeq();

        // search
        ContactsInfoValue contactsInfo = service.getContactsEditInfo(Long.parseLong(contactsSeq));

        // hedaer info : value -> model
        BeanUtilEx.copyProperties(model, contactsInfo.getHeaderInfo());

        // phoneList info : value -> model
        if (contactsInfo.getPhoneList() != null) {
            model.setPhoneList(new ArrayList<TContactsPhoneValue>());
            // java.util.Collections.copy(model.getPhoneList(),
            // contactsInfo.getPhoneList());
            model.getPhoneList().addAll(contactsInfo.getPhoneList());
        }

        log.debug("search end");
    }

    public String update() throws Exception {
        log.debug("update start");

        this.removeNullPhontList();

        if (!checkInput()) {
            return "welcome";
        }

        // hedaer info : model -> value
        TContactsHeaderValue updHeaderInfo = new TContactsHeaderValue();
        BeanUtilEx.copyProperties(updHeaderInfo, model);
        // phoneList info : model -> value
        List<TContactsPhoneValue> updPhoneInfoList = new ArrayList<TContactsPhoneValue>();
        if (model.getPhoneList() != null) {
            // java.util.Collections.copy(updPhoneInfoList,
            // model.getPhoneList());
            updPhoneInfoList.addAll(model.getPhoneList());
        }

        // parameter
        ContactsInfoValue contactsInfo = new ContactsInfoValue();
        contactsInfo.setHeaderInfo(updHeaderInfo);
        contactsInfo.setPhoneList(updPhoneInfoList);

        // login info
        LoginInfo loginInfo = super.getLoginInfo();

        if (CommonConst.ACTION_TYPE_NEW.equals(model.getAcctionType())) {
            // new mode

            // create
            service.createContactsEditInfo(contactsInfo, loginInfo);
            super.addActionMessage(super.getText("message.create.sucess"));
        } else {
            // edit mode

            // update
            try {
                service.updateContactsEditInfo(contactsInfo, loginInfo);
                super.addActionMessage(super.getText("message.update.sucess"));
            } catch (SSHSampleException e) {
                super.addActionError(super.getText("error.exclusive"));
                return "welcome";
            }
        }

        model.setReturnUrl("contacts-list.action");

        log.debug("update end");
        return Action.SUCCESS;
    }

    private void removeNullPhontList() {
        List<TContactsPhoneValue> phoneList = model.getPhoneList();
        if (phoneList != null) {
            for (int i = 0; i < phoneList.size(); i++) {
                TContactsPhoneValue phoneInfo = phoneList.get(i);
                if (phoneInfo == null) {
                    phoneList.remove(i);
                    i--;
                }
            }
        }
    }

    private boolean checkInput() {
        boolean validate = true;

        String nameFamily = model.getNameFamily();
        String nameGiven = model.getNameGiven();
        String nameFamilyPhonetic = model.getNameFamilyPhonetic();
        String nameGivenPhonetic = model.getNameGivenPhonetic();
        String nickName = model.getNickName();
        String note = model.getNote();
        String websiteUrl = model.getWebsiteUrl();

        if (nameFamily.length() > 5) {
            String[] msgArgs = { "姓名（汉字）-姓", "5" };
            String errorMsg = super.getText("validate.error.length", msgArgs);
            super.addActionError(errorMsg);
            validate = false;
        }

        if (nameGiven.length() > 5) {
            String[] msgArgs = { "姓名（汉字）-名", "5" };
            String errorMsg = super.getText("validate.error.length", msgArgs);
            super.addActionError(errorMsg);
            validate = false;
        }

        if (nameFamilyPhonetic.length() > 10) {
            String[] msgArgs = { "姓名（拼音）-姓", "10" };
            String errorMsg = super.getText("validate.error.length", msgArgs);
            super.addActionError(errorMsg);
            validate = false;
        }

        if (nameGivenPhonetic.length() > 10) {
            String[] msgArgs = { "姓名（拼音）-名", "10" };
            String errorMsg = super.getText("validate.error.length", msgArgs);
            super.addActionError(errorMsg);
            validate = false;
        }

        if (nickName.length() > 10) {
            String[] msgArgs = { "昵称", "10" };
            String errorMsg = super.getText("validate.error.length", msgArgs);
            super.addActionError(errorMsg);
            validate = false;
        }

        if (note.length() > 50) {
            String[] msgArgs = { "备忘", "50" };
            String errorMsg = super.getText("validate.error.length", msgArgs);
            super.addActionError(errorMsg);
            validate = false;
        }

        if (websiteUrl.length() > 30) {
            String[] msgArgs = { "个人主页", "30" };
            String errorMsg = super.getText("validate.error.length", msgArgs);
            super.addActionError(errorMsg);
            validate = false;
        }

        List<TContactsPhoneValue> phoneList = model.getPhoneList();
        if (phoneList != null) {
            for (TContactsPhoneValue phoneInfo : phoneList) {
                if (phoneInfo != null) {
                    String phoneType = phoneInfo.getPhoneType();
                    String phoneLabel = phoneInfo.getPhoneLabel();
                    String phoneNumber = phoneInfo.getPhoneNumber();

                    if (StringUtils.isEmpty(phoneType)) {
                        String[] msgArgs = { "电话类别" };
                        String errorMsg = super.getText("validate.error.required", msgArgs);
                        super.addActionError(errorMsg);
                        validate = false;
                    }

                    if (phoneLabel.length() > 10) {
                        String[] msgArgs = { "自定义名", "10" };
                        String errorMsg = super.getText("validate.error.length", msgArgs);
                        super.addActionError(errorMsg);
                        validate = false;
                    }

                    if (phoneNumber.length() > 11) {
                        String[] msgArgs = { "号码", "11" };
                        String errorMsg = super.getText("validate.error.length", msgArgs);
                        super.addActionError(errorMsg);
                        validate = false;
                    }

                }

            }
        }

        return validate;
    }
}
