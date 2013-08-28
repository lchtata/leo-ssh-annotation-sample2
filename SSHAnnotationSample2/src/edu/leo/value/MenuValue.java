package edu.leo.value;

import java.io.Serializable;
import java.util.List;

public class MenuValue implements Serializable {

    private static final long serialVersionUID = -4652335797025931447L;

    private Long menuId;
    private String menuNm;
    private String url;
    /** 1:can use */
    private String isValid;

    private List<MenuValue> subMenuList;

    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    public String getMenuNm() {
        return menuNm;
    }

    public void setMenuNm(String menuNm) {
        this.menuNm = menuNm;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getIsValid() {
        return isValid;
    }

    public void setIsValid(String isValid) {
        this.isValid = isValid;
    }

    public List<MenuValue> getSubMenuList() {
        return subMenuList;
    }

    public void setSubMenuList(List<MenuValue> subMenuList) {
        this.subMenuList = subMenuList;
    }
}
