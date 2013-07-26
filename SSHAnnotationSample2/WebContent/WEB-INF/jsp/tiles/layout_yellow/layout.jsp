<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="tiles" uri="/tiles-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="css/jqueryuiplugin/superfish-v1.7.4/superfish_custom.css" />
<link type="text/css" rel="stylesheet" href="css/jqueryui/layout_yellow/jquery-ui-1.9.2.sunny.min.css" />
<link type="text/css" rel="stylesheet" href="css/layout_default/common.css" />
<style type="text/css">
    .rtl {
        direction: rtl;
    }
    .ui-widget {
        font-size:12px !important;
    }
</style>
<script type="text/javascript" src="js/jquery/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="js/jqueryui/layout_yellow/jquery-ui-1.9.2.sunny.min.js"></script>
<script type="text/javascript" src="js/jqueryplugin/superfish-v1.7.4/hoverIntent.js"></script>
<script type="text/javascript" src="js/jqueryplugin/superfish-v1.7.4/superfish.min.js"></script>
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

        $("ul.sf-menu li").addClass("ui-state-default");

        $("ul.sf-menu li").hover(function() {
            $(this).addClass('ui-state-hover');
        }, function() {
            $(this).removeClass('ui-state-hover');
        });

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
                    <li class="current">
                        <a href="javascript:void(0);">联系人管理</a>
                        <ul>
                            <li>
                                <a href="contacts-list.action">联系人列表</a>
                            </li>
                            <li class="current">
                                <a href="javascript:void(0);">menu item11</a>
                                <ul>
                                    <li class="current"><a href="javascript:void(0);">menu item</a></li>
                                    <li><a href="javascript:void(0);">menu item111</a></li>
                                    <li class="ui-state-disabled"><a href="javascript:void(0);">menu item112</a></li>
                                    <li><a href="javascript:void(0);">menu item113</a></li>
                                    <li><a href="javascript:void(0);">menu item114</a></li>
                                </ul>
                            </li>
                            <li>
                                <a href="javascript:void(0);">menu item12</a>
                                <ul>
                                    <li><a href="javascript:void(0);">menu item121</a></li>
                                    <li><a href="javascript:void(0);">menu item122</a></li>
                                    <li><a href="javascript:void(0);">menu item123</a></li>
                                    <li><a href="javascript:void(0);">menu item124</a></li>
                                    <li><a href="javascript:void(0);">menu item125</a></li>
                                </ul>
                            </li>
                            <li>
                                <a href="javascript:void(0);">menu item13</a>
                                <ul>
                                    <li><a href="javascript:void(0);">menu item131</a></li>
                                    <li><a href="javascript:void(0);">menu item132</a></li>
                                    <li><a href="javascript:void(0);">menu item133</a></li>
                                    <li><a href="javascript:void(0);">menu item134</a></li>
                                    <li><a href="javascript:void(0);">menu item135</a></li>
                                </ul>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <a href="javascript:void(0);">menu item 2</a>
                       </li>
                    <li>
                        <a href="javascript:void(0);">menu item 3</a>
                        <ul>
                            <li>
                                <a href="javascript:void(0);">menu item31</a>
                                <ul>
                                    <li><a href="javascript:void(0);">short1</a></li>
                                    <li><a href="javascript:void(0);">short2</a></li>
                                    <li><a href="javascript:void(0);">short3</a></li>
                                    <li><a href="javascript:void(0);">short4</a></li>
                                    <li><a href="javascript:void(0);">short5</a></li>
                                </ul>
                            </li>
                            <li>
                                <a href="javascript:void(0);">menu item32</a>
                                <ul>
                                    <li><a href="javascript:void(0);">menu item321</a></li>
                                    <li><a href="javascript:void(0);">menu item322</a></li>
                                    <li><a href="javascript:void(0);">menu item323</a></li>
                                    <li><a href="javascript:void(0);">menu item324</a></li>
                                    <li><a href="javascript:void(0);">menu item325</a></li>
                                </ul>
                            </li>
                            <li>
                                <a href="javascript:void(0);">menu item33</a>
                                <ul>
                                    <li><a href="javascript:void(0);">menu item331</a></li>
                                    <li><a href="javascript:void(0);">menu item332</a></li>
                                    <li><a href="javascript:void(0);">menu item333</a></li>
                                    <li><a href="javascript:void(0);">menu item334</a></li>
                                    <li><a href="javascript:void(0);">menu item335</a></li>
                                </ul>
                            </li>
                            <li>
                                <a href="javascript:void(0);">menu item34</a>
                                <ul>
                                    <li><a href="javascript:void(0);">menu item341</a></li>
                                    <li><a href="javascript:void(0);">menu item342</a></li>
                                    <li><a href="javascript:void(0);">menu item343</a></li>
                                    <li><a href="javascript:void(0);">menu item344</a></li>
                                    <li><a href="javascript:void(0);">menu item345</a></li>
                                </ul>
                            </li>
                            <li>
                                <a href="javascript:void(0);">menu item35</a>
                                <ul>
                                    <li><a href="javascript:void(0);">menu item351</a></li>
                                    <li><a href="javascript:void(0);">menu item352</a></li>
                                    <li><a href="javascript:void(0);">menu item353</a></li>
                                    <li><a href="javascript:void(0);">menu item354</a></li>
                                    <li><a href="javascript:void(0);">menu item355</a></li>
                                </ul>
                            </li>
                        </ul>
                    </li>
                    <li><a href="javascript:void(0);">menu item 4</a></li>
                    <li class="ui-state-disabled"><a href="javascript:void(0);">menu item 5</a></li>
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
