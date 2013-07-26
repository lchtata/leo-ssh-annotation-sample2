package edu.leo.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import edu.leo.common.framework.CommonModel;

@Scope("request")
@Controller
public class ThemeChangeModel extends CommonModel {

    private static final long serialVersionUID = -7810396495163290200L;

    private String nowPageUrl;
    private String themeName;

    public String getNowPageUrl() {
        return nowPageUrl;
    }

    public void setNowPageUrl(String nowPageUrl) {
        this.nowPageUrl = nowPageUrl;
    }

    public String getThemeName() {
        return themeName;
    }

    public void setThemeName(String themeName) {
        this.themeName = themeName;
    }
}
