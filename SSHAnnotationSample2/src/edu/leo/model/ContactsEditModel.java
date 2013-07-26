package edu.leo.model;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import edu.leo.common.framework.CommonModel;
import edu.leo.value.TContactsPhoneValue;

@Scope("request")
@Controller
public class ContactsEditModel extends CommonModel {

    private static final long serialVersionUID = 1851159928841356797L;

    private String acctionType = "0";

    private String contactsSeq;
    private String name;
    private String nameFamily;
    private String nameGiven;
    private String nameFamilyPhonetic;
    private String nameGivenPhonetic;
    private String nickName;
    private String note;
    private String websiteUrl;
    private String updCnt;

    // private List<TContactsPhoneValue> phoneDispList;
    private List<TContactsPhoneValue> phoneList;

    public String getAcctionType() {
        return acctionType;
    }

    public void setAcctionType(String acctionType) {
        this.acctionType = acctionType;
    }

    public String getContactsSeq() {
        return contactsSeq;
    }

    public void setContactsSeq(String contactsSeq) {
        this.contactsSeq = contactsSeq;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameFamily() {
        return nameFamily;
    }

    public void setNameFamily(String nameFamily) {
        this.nameFamily = nameFamily;
    }

    public String getNameGiven() {
        return nameGiven;
    }

    public void setNameGiven(String nameGiven) {
        this.nameGiven = nameGiven;
    }

    public String getNameFamilyPhonetic() {
        return nameFamilyPhonetic;
    }

    public void setNameFamilyPhonetic(String nameFamilyPhonetic) {
        this.nameFamilyPhonetic = nameFamilyPhonetic;
    }

    public String getNameGivenPhonetic() {
        return nameGivenPhonetic;
    }

    public void setNameGivenPhonetic(String nameGivenPhonetic) {
        this.nameGivenPhonetic = nameGivenPhonetic;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getWebsiteUrl() {
        return websiteUrl;
    }

    public void setWebsiteUrl(String websiteUrl) {
        this.websiteUrl = websiteUrl;
    }

    public String getUpdCnt() {
        return updCnt;
    }

    public void setUpdCnt(String updCnt) {
        this.updCnt = updCnt;
    }

    public List<TContactsPhoneValue> getPhoneList() {
        return phoneList;
    }

    public void setPhoneList(List<TContactsPhoneValue> phoneList) {
        this.phoneList = phoneList;
    }
}
