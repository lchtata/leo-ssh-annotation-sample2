package edu.leo.model;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import edu.leo.common.framework.CommonModel;
import edu.leo.value.TContactsHeaderValue;
import edu.leo.value.TContactsPhoneValue;

@Scope("request")
@Controller
public class ContactsDetailShowModel extends CommonModel {

    private static final long serialVersionUID = -8081857965718851629L;

    private String contactsSeq;

    private TContactsHeaderValue headerInfo;

    private List<TContactsPhoneValue> phoneList;

    public String getContactsSeq() {
        return contactsSeq;
    }

    public void setContactsSeq(String contactsSeq) {
        this.contactsSeq = contactsSeq;
    }

    public TContactsHeaderValue getHeaderInfo() {
        return headerInfo;
    }

    public void setHeaderInfo(TContactsHeaderValue headerInfo) {
        this.headerInfo = headerInfo;
    }

    public List<TContactsPhoneValue> getPhoneList() {
        return phoneList;
    }

    public void setPhoneList(List<TContactsPhoneValue> phoneList) {
        this.phoneList = phoneList;
    }
}
