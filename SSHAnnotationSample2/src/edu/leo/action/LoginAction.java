package edu.leo.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;

import edu.leo.common.CommonConst;
import edu.leo.common.annotation.EduLeoAnnotation;
import edu.leo.common.framework.CommonAction;
import edu.leo.model.LoginModel;
import edu.leo.service.ILoginService;
import edu.leo.value.LoginInfo;
import edu.leo.value.MenuValue;

@Scope("prototype")
// @Namespace("/")
@ParentPackage("default")
@EduLeoAnnotation(name = "", loginCheck = false)
@Results({ @Result(name = "welcome", location = "/WEB-INF/jsp/login.jsp"), @Result(name = Action.SUCCESS, type = "chain", location = "main") })
public class LoginAction extends CommonAction implements ModelDriven<LoginModel> {

    private static final long serialVersionUID = 1699636850099354209L;

    @Resource
    private LoginModel model;

    public LoginModel getModel() {
        return model;
    }

    @Autowired(required = true)
    private ILoginService service;

    public String execute() throws Exception {
        log.debug("execute start");

        this.setLogoutSesstionAtrribute();

        log.debug("execute end");
        return "welcome";
    }

    public String login() throws Exception {
        log.debug("login start");

        String forward = null;

        String loginId = model.getLoginId();
        String password = model.getPassword();

        // CommonConst.LoginCheck result = service.doLogin(loginId, password);
        LoginInfo loginInfo = service.doLogin(loginId, password);
        if (loginInfo != null) {
            forward = SUCCESS;

            // get menu list
            List<MenuValue> menuList = this.makeMenuList();

            this.setLoginSesstionAtrribute(loginInfo, menuList);

            log.info("login sucess");
        } else {
            forward = "welcome";
            String msg = getText("error.login_failed");
            super.addActionError(msg);
            this.setLogoutSesstionAtrribute();

            log.info("login error");
        }

        log.debug("login end");
        return forward;
    }

    public String logout() throws Exception {
        log.debug("logout start");

        this.setLogoutSesstionAtrribute();

        log.debug("logout end");
        return "welcome";
    }

    private List<MenuValue> makeMenuList() {
        List<MenuValue> menulist = new ArrayList<MenuValue>();

        MenuValue menu;
        List<MenuValue> subMenuList;
        MenuValue subMenu;
        List<MenuValue> sub3rdMenuList;
        MenuValue sub3rdMenu;

        Long menuId = 1L;

        /** ------------------------------------------------------- */

        // ■top menu - 联系人管理
        menu = new MenuValue();
        menu.setMenuId(menuId);
        menu.setMenuNm("联系人管理");
        menu.setIsValid("1");
        menuId++;

        // sub menu 1
        subMenuList = new ArrayList<MenuValue>();
        subMenu = new MenuValue();
        subMenu.setMenuId(menuId);
        subMenu.setMenuNm("联系人管理列表");
        subMenu.setUrl("contacts-list.action");
        subMenu.setIsValid("1");
        menuId++;
        subMenuList.add(subMenu);

        // sub menu 2
        subMenu = new MenuValue();
        subMenu.setMenuId(menuId);
        subMenu.setMenuNm("menu sub item 2");
        subMenu.setIsValid("1");
        menuId++;

        // sub menu 2 - sub3rd menu 1
        sub3rdMenuList = new ArrayList<MenuValue>();
        sub3rdMenu = new MenuValue();
        sub3rdMenu.setMenuId(menuId);
        sub3rdMenu.setMenuNm("menu sub item 21");
        sub3rdMenu.setIsValid("1");
        menuId++;
        sub3rdMenuList.add(sub3rdMenu);

        // sub menu 2 - sub3rd menu 2
        sub3rdMenu = new MenuValue();
        sub3rdMenu.setMenuId(menuId);
        sub3rdMenu.setMenuNm("menu sub item 22");
        menuId++;
        sub3rdMenuList.add(sub3rdMenu);

        // sub menu 2 - sub3rd menu 3
        sub3rdMenu = new MenuValue();
        sub3rdMenu.setMenuId(menuId);
        sub3rdMenu.setMenuNm("menu sub item 23");
        sub3rdMenu.setIsValid("1");
        menuId++;
        sub3rdMenuList.add(sub3rdMenu);
        subMenu.setSubMenuList(sub3rdMenuList);

        subMenuList.add(subMenu);

        // sub menu 3
        subMenu = new MenuValue();
        subMenu.setMenuId(menuId);
        subMenu.setMenuNm("menu sub item 3");
        subMenu.setIsValid("1");
        menuId++;
        subMenuList.add(subMenu);

        // sub menu 4
        subMenu = new MenuValue();
        subMenu.setMenuId(menuId);
        subMenu.setMenuNm("menu sub item 4");
        subMenu.setIsValid("1");
        menuId++;
        subMenuList.add(subMenu);

        menu.setSubMenuList(subMenuList);
        menulist.add(menu);

        /** ------------------------------------------------------- */

        // ■top menu - jQuery示例
        menu = new MenuValue();
        menu.setMenuId(menuId);
        menu.setMenuNm("jQuery示例");
        menu.setIsValid("1");
        menuId++;

        // sub menu 1
        subMenuList = new ArrayList<MenuValue>();
        subMenu = new MenuValue();
        subMenu.setMenuId(menuId);
        subMenu.setMenuNm("日历Calendar");
        subMenu.setUrl("forward!gotoCalendar.action");
        subMenu.setIsValid("1");
        menuId++;
        subMenuList.add(subMenu);

        // sub menu 2
        subMenu = new MenuValue();
        subMenu.setMenuId(menuId);
        subMenu.setMenuNm("menu sub item 2");
        subMenu.setIsValid("1");
        menuId++;

        // sub menu 2 - sub3rd menu 1
        sub3rdMenuList = new ArrayList<MenuValue>();
        sub3rdMenu = new MenuValue();
        sub3rdMenu.setMenuId(menuId);
        sub3rdMenu.setMenuNm("menu sub item 21");
        sub3rdMenu.setIsValid("1");
        menuId++;
        sub3rdMenuList.add(sub3rdMenu);

        // sub menu 2 - sub3rd menu 2
        sub3rdMenu = new MenuValue();
        sub3rdMenu.setMenuId(menuId);
        sub3rdMenu.setMenuNm("menu sub item 22");
        menuId++;
        sub3rdMenuList.add(sub3rdMenu);

        // sub menu 2 - sub3rd menu 3
        sub3rdMenu = new MenuValue();
        sub3rdMenu.setMenuId(menuId);
        sub3rdMenu.setMenuNm("menu sub item 23");
        sub3rdMenu.setIsValid("1");
        menuId++;
        sub3rdMenuList.add(sub3rdMenu);
        subMenu.setSubMenuList(sub3rdMenuList);

        subMenuList.add(subMenu);

        // sub menu 3
        subMenu = new MenuValue();
        subMenu.setMenuId(menuId);
        subMenu.setMenuNm("menu sub item 3");
        subMenu.setIsValid("1");
        menuId++;
        subMenuList.add(subMenu);

        // sub menu 4
        subMenu = new MenuValue();
        subMenu.setMenuId(menuId);
        subMenu.setMenuNm("menu sub item 4");
        subMenu.setIsValid("1");
        menuId++;
        subMenuList.add(subMenu);

        menu.setSubMenuList(subMenuList);
        menulist.add(menu);

        /** ------------------------------------------------------- */

        // ■top menu - 其他示例
        menu = new MenuValue();
        menu.setMenuId(menuId);
        menu.setMenuNm("其他示例");
        menu.setIsValid("1");
        menuId++;

        // sub menu 1
        subMenuList = new ArrayList<MenuValue>();
        subMenu = new MenuValue();
        subMenu.setMenuId(menuId);
        subMenu.setMenuNm("文件上传");
        subMenu.setUrl("file-upload.action");
        subMenu.setIsValid("1");
        menuId++;
        subMenuList.add(subMenu);

        // sub menu 2
        subMenu = new MenuValue();
        subMenu.setMenuId(menuId);
        subMenu.setMenuNm("Java Mail 例子  *未完成");
        subMenu.setIsValid("1");
        menuId++;
        subMenuList.add(subMenu);

        menu.setSubMenuList(subMenuList);
        menulist.add(menu);

        /** ------------------------------------------------------- */

        return menulist;
    }

    private void setLoginSesstionAtrribute(LoginInfo loginInfo, List<MenuValue> menulist) {
        super.getSession().setAttribute(CommonConst.SESSION_KEY_LOGIN_INFO, loginInfo);
        super.getSession().setAttribute(CommonConst.SESSION_KEY_THEME, CommonConst.THEME_DEFAULT);
        super.getSession().setAttribute(CommonConst.SESSION_KEY_MENULIST, menulist);
    }

    private void setLogoutSesstionAtrribute() {
        super.getSession().removeAttribute(CommonConst.SESSION_KEY_LOGIN_INFO);
        super.getSession().removeAttribute(CommonConst.SESSION_KEY_THEME);
        super.getSession().removeAttribute(CommonConst.SESSION_KEY_MENULIST);
    }
}
