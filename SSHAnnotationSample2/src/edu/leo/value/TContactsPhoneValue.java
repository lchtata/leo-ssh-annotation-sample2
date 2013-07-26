package edu.leo.value;

import java.io.Serializable;
import java.util.Date;

public class TContactsPhoneValue implements Serializable {

    private static final long serialVersionUID = -6153023609964152673L;

    private Long contactsSeq;
    private String phoneType;
    private String phoneLabel;
    private String phoneNumber;
    private Date insDate;
    private String insUserId;
    private Date updDate;
    private String updUserId;
    private Date delDate;
    private String delUserId;
    private String delFlg;
    private Long updCnt;

    public Long getContactsSeq() {
        return contactsSeq;
    }

    public void setContactsSeq(Long contactsSeq) {
        this.contactsSeq = contactsSeq;
    }

    public String getPhoneType() {
        return phoneType;
    }

    public void setPhoneType(String phoneType) {
        this.phoneType = phoneType;
    }

    public String getPhoneLabel() {
        return phoneLabel;
    }

    public void setPhoneLabel(String phoneLabel) {
        this.phoneLabel = phoneLabel;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getInsDate() {
        return insDate;
    }

    public void setInsDate(Date insDate) {
        this.insDate = insDate;
    }

    public String getInsUserId() {
        return insUserId;
    }

    public void setInsUserId(String insUserId) {
        this.insUserId = insUserId;
    }

    public Date getUpdDate() {
        return updDate;
    }

    public void setUpdDate(Date updDate) {
        this.updDate = updDate;
    }

    public String getUpdUserId() {
        return updUserId;
    }

    public void setUpdUserId(String updUserId) {
        this.updUserId = updUserId;
    }

    public Date getDelDate() {
        return delDate;
    }

    public void setDelDate(Date delDate) {
        this.delDate = delDate;
    }

    public String getDelUserId() {
        return delUserId;
    }

    public void setDelUserId(String delUserId) {
        this.delUserId = delUserId;
    }

    public String getDelFlg() {
        return delFlg;
    }

    public void setDelFlg(String delFlg) {
        this.delFlg = delFlg;
    }

    public Long getUpdCnt() {
        return updCnt;
    }

    public void setUpdCnt(Long updCnt) {
        this.updCnt = updCnt;
    }
}
