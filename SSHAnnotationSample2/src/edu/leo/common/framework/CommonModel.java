package edu.leo.common.framework;

import java.io.Serializable;

public class CommonModel implements Serializable {

    private static final long serialVersionUID = 3728531487294320675L;

    private String returnUrl;

    public String getReturnUrl() {
        return returnUrl;
    }

    public void setReturnUrl(String returnUrl) {
        this.returnUrl = returnUrl;
    }
}
