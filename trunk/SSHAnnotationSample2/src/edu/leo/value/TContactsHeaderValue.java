package edu.leo.value;

import java.io.Serializable;
import java.util.Date;

public class TContactsHeaderValue implements Serializable {

    private static final long serialVersionUID = -473099391532312200L;

    private Long contactsSeq;
    private String name;
    private String nameFamily;
    private String nameGiven;
    private String nameFamilyPhonetic;
    private String nameGivenPhonetic;
    private String nickName;
    private String note;
    private String websiteUrl;
    private Date lastUpdateDate;
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

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
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
