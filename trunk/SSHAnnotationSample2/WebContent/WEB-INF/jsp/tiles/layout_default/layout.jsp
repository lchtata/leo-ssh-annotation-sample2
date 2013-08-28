<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="tiles" uri="/tiles-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="css/jqueryuiplugin/superfish-v1.7.4/superfish_custom.css" />
<link type="text/css" rel="stylesheet" href="css/jqueryui/layout_default/jquery-ui-1.9.2.default.min.css" />
<link type="text/css" rel="stylesheet" href="css/common.css" />
<style type="text/css">
    .rtl {
        direction: rtl;
    }
    .ui-widget {
        font-size:12px !important;
    }
</style>
<script type="text/javascript" src="js/jquery/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="js/jqueryui/layout_default/jquery-ui-1.9.2.default.min.js"></script>
<script type="text/javascript" src="js/jqueryplugin/superfish-v1.7.4/hoverIntent.js"></script>
<script type="text/javascript" src="js/jqueryplugin/superfish-v1.7.4/superfish.min.js"></script>
<script type="text/javascript" src="js/jqueryplugin/blockui-2.64/jquery.blockUI.js"></script>
<script type="text/javascript" src="js/common.js"></script>
<title>Leo Edu</title>
<script language="JavaScript" type="text/javascript">
    $(document).ready(function() {
        var superFishMenu = $('#menuul').superfish({
            //useClick: true
            delay:       0,                               // one second delay on mouseout
            animation:   {opacity:'show',height:'show'},  // fade-in and slide-down animation
            speed:       'fast',                          // faster animation speed
            autoArrows:  false                            // disable generation of arrow mark-up
        });
        superFishMenu.leoStyleMenu();


        $('#layoutBlueImg').click(function(){
            $("#nowPageUrl").val(window.location.href);
            $("#themeName").val("layout_default");
            var themeChangeForm = $("#themeChangeForm");
            themeChangeForm.attr("action", "theme-change.action");
            themeChangeForm.submit();
        });
        $('#layoutYeelowImg').click(function(){
            $("#nowPageUrl").val(window.location.href);
            $("#themeName").val("layout_yellow");
            var themeChangeForm = $("#themeChangeForm");
            themeChangeForm.attr("action", "theme-change.action");
            themeChangeForm.submit();
        });
        $('#openFirstSubMenuBtn').click(function(){
            superFishMenu.children('li:first').superfish('show');
        });
        $('#closeFirstSubMenuBtn').click(function(){
            superFishMenu.children('li:first').superfish('hide');
        });
        $('#destroySuperfishBtn').click(function(){
            superFishMenu.superfish('destroy');
        });
        $('#restoreSuperfishBtn').click(function(){
            superFishMenu.superfish();
        });

        // jquery ui
        $("input[type='button']").button();
    });
</script>

<%--insert jsp javascript here --%>
<tiles:insertAttribute name="originalJavascript" />

</head>
<body>

<s:form id="themeChangeForm" name="themeChangeForm" method="post">
    <input type="hidden" id="nowPageUrl" name="nowPageUrl" />
    <input type="hidden" id="themeName" name="themeName" />
</s:form>

    <table class="layout_table">
        <tr>
            <td style="text-align:right;">
                <%--Header--%>
                菜单选项：
                <input type="button" id="openFirstSubMenuBtn" value="打开第一个子菜单" />
                <input type="button" id="closeFirstSubMenuBtn" value="关闭第一个子菜单" />
                <input type="button" id="destroySuperfishBtn" value="失效" />
                <input type="button" id="restoreSuperfishBtn" value="恢复" />
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                主题：
                <input type="image" id="layoutBlueImg" src="img/layout/ico_dots_blue.gif" title="默认" border=0/>
                <input type="image" id="layoutYeelowImg" src="img/layout/ico_dots_green.gif" title="黄色" border=0/>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <s:property value="#session.SESSION_KEY_LOGIN_INFO.name" />
                <span style="color:silver;font-weight:bold;">∥</span>
                <a id="logoutLink" href="login!logout.action">Logout</a>

            </td>
        </tr>
        <tr>
            <td>
                <%--Menu--%>
                <ul class="sf-menu" id="menuul">
                    <s:iterator value="#session.SESSION_KEY_MENULIST" id="element">
                        <%--Menu top--%>
                        <li <s:if test='#element.isValid=="1"'></s:if><s:else>class="ui-state-disabled"</s:else>>
                            <a href='<s:if test="#element.url==null">javascript:void(0);</s:if><s:else><s:property value="#element.url" /></s:else>'><s:property value="#element.menuNm" /></a>

                            <%--Menu sub 1--%>
                            <s:if test="#element.subMenuList!=null">
                            <ul>
                            <s:iterator value="#element.subMenuList" id="subElement">
                                <li <s:if test='#subElement.isValid=="1"'></s:if><s:else>class="ui-state-disabled"</s:else>>
                                    <a href='<s:if test="#subElement.url==null">javascript:void(0);</s:if><s:else><s:property value="#subElement.url" /></s:else>'><s:property value="#subElement.menuNm" /></a>

                                    <%--Menu sub 2--%>
                                    <s:if test="#subElement.subMenuList!=null">
                                    <ul>
                                    <s:iterator value="#subElement.subMenuList" id="sub3rdElement">
                                        <li <s:if test='#sub3rdElement.isValid=="1"'></s:if><s:else>class="ui-state-disabled"</s:else>>
                                            <a href='<s:if test="#sub3rdElement.url==null">javascript:void(0);</s:if><s:else><s:property value="#sub3rdElement.url" /></s:else>'><s:property value="#sub3rdElement.menuNm" /></a>
                                        </li>
                                    </s:iterator>
                                    </ul>
                                    </s:if>
                                </li>
                            </s:iterator>
                            </ul>
                            </s:if>
                        </li>
                    </s:iterator>
                </ul>
            </td>
        </tr>
        <tr>
            <td class="layout_main_td">
                <%-- Main --%>
                <tiles:insertAttribute name="body"/>
            </td>
        </tr>
        <tr>
            <td>
            <%--Footer--%>
                &nbsp;
            </td>
        </tr>
    </table>
</body>
</html>
