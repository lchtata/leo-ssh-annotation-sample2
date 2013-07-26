package edu.leo.value;

import java.io.Serializable;

public class ContactsListSearchParam implements Serializable {

    private static final long serialVersionUID = 6880162568209250621L;

    private int firstResult;

    private int maxResult;

    private String srchName;

    public int getFirstResult() {
        return firstResult;
    }

    public void setFirstResult(int firstResult) {
        this.firstResult = firstResult;
    }

    public int getMaxResult() {
        return maxResult;
    }

    public void setMaxResult(int maxResult) {
        this.maxResult = maxResult;
    }

    public String getSrchName() {
        return srchName;
    }

    public void setSrchName(String srchName) {
        this.srchName = srchName;
    }
}
