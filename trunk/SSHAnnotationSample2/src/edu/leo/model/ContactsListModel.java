package edu.leo.model;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import edu.leo.common.framework.CommonModel;
import edu.leo.value.TContactsHeaderValue;

@Scope("request")
@Controller
public class ContactsListModel extends CommonModel {

    private static final long serialVersionUID = -5699208285515684179L;

    /** name */
    private String srchName;

    private int count = 0;
    private int pageCount = 0;
    private int pageNum = 0;
    private int firstResult = 0;
    private boolean showResult = false;

    List<TContactsHeaderValue> contactsList = null;

    public String getSrchName() {
        return srchName;
    }

    public void setSrchName(String srchName) {
        this.srchName = srchName;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getFirstResult() {
        return firstResult;
    }

    public void setFirstResult(int firstResult) {
        this.firstResult = firstResult;
    }

    public boolean isShowResult() {
        return showResult;
    }

    public void setShowResult(boolean showResult) {
        this.showResult = showResult;
    }

    public List<TContactsHeaderValue> getContactsList() {
        return contactsList;
    }

    public void setContactsList(List<TContactsHeaderValue> contactsList) {
        this.contactsList = contactsList;
    }
}
