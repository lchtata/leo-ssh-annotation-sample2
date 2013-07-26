package edu.leo.value;

import java.io.Serializable;
import java.util.List;

public class ContactsInfoValue implements Serializable {

    private static final long serialVersionUID = -2821495023830407569L;

    private TContactsHeaderValue headerInfo = null;

    private List<TContactsPhoneValue> phoneList = null;

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
