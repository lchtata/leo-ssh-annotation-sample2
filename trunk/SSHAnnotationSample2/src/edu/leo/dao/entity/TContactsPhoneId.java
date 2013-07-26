// default package
// Generated 2013/07/03 14:17:38 by Hibernate Tools 3.4.0.CR1
package edu.leo.dao.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * TContactsPhoneId generated by hbm2java
 */
@Embeddable
public class TContactsPhoneId implements java.io.Serializable {

    private Long contactsSeq;
    private String phoneType;

    public TContactsPhoneId() {
    }

    public TContactsPhoneId(Long contactsSeq, String phoneType) {
        this.contactsSeq = contactsSeq;
        this.phoneType = phoneType;
    }

    @Column(name = "contacts_seq", nullable = false, precision = 18, scale = 0)
    public Long getContactsSeq() {
        return this.contactsSeq;
    }

    public void setContactsSeq(Long contactsSeq) {
        this.contactsSeq = contactsSeq;
    }

    @Column(name = "phone_type", nullable = false, length = 2)
    public String getPhoneType() {
        return this.phoneType;
    }

    public void setPhoneType(String phoneType) {
        this.phoneType = phoneType;
    }

    public boolean equals(Object other) {
        if ((this == other))
            return true;
        if ((other == null))
            return false;
        if (!(other instanceof TContactsPhoneId))
            return false;
        TContactsPhoneId castOther = (TContactsPhoneId) other;

        return ((this.getContactsSeq() == castOther.getContactsSeq()) || (this.getContactsSeq() != null && castOther.getContactsSeq() != null && this.getContactsSeq().equals(castOther.getContactsSeq()))) && ((this.getPhoneType() == castOther.getPhoneType()) || (this.getPhoneType() != null && castOther.getPhoneType() != null && this.getPhoneType().equals(castOther.getPhoneType())));
    }

    public int hashCode() {
        int result = 17;

        result = 37 * result + (getContactsSeq() == null ? 0 : this.getContactsSeq().hashCode());
        result = 37 * result + (getPhoneType() == null ? 0 : this.getPhoneType().hashCode());
        return result;
    }

}
