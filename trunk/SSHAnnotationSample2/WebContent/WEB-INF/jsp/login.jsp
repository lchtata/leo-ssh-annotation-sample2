<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="css/jqueryui/layout_default/jquery-ui-1.9.2.default.min.css" />
<style type="text/css">
    .ui-widget {
        font-size:12px !important;
    }
</style>
<script type="text/javascript" src="js/jquery/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="js/jqueryui/layout_default/jquery-ui-1.9.2.default.min.js"></script>
<title>Login</title>
<script language="JavaScript" type="text/javascript">
    $(document).ready(function(){
        // jquery ui
        $("input[type='button']").button();

        $("#loginBtn").click(function(){
            doLogin();
        });

        /***/
        $("#loginId").keydown(function(event){
            // use [$.ui.keyCode.ENTER] must include jquery ui
            if (event.which == $.ui.keyCode.ENTER) {
                $("#password").focus();
            }
        });

        /***/
        $("#password").keydown(function(event){
            // use [$.ui.keyCode.ENTER] must include jquery ui
            if (event.which == $.ui.keyCode.ENTER) {
                doLogin();
            }
        });
    });

    function doLogin(){
        $("#loginForm").attr("action", "login!login.action");
        $("#loginForm").submit();
    }
</script>
</head>
<body>
    <form name="loginForm" id="loginForm" action="login.action" method="post">
        <div id="container">
            <div align="center">
            </div>

            <div id="MainArea" class="L1">
                <br />
                <br /> <br /> <br />
                <div class="shadow F2">
                    <div class="sa">
                        <div align="center">
                            <span>
                                <font color="red">
                                    <s:actionerror/>
                                    <s:actionmessage/>
                                    <s:property value="resultMsg" />
                                </font>
                            </span>
                            <table cellspacing="13" cellpadding="0" align="center" style="margin-top: 40px;">
                                <tbody>
                                    <tr>
                                        <td><span style="font-family: 'Meiryo';">login id</span></td>
                                        <td>
                                        <s:textfield name="loginId" id="loginId" cssStyle="ime-mode: disabled;" size="18" />
                                        </td>
                                    </tr>
                                    <tr>
                                        <td><span style="font-family: 'Meiryo';">password</span></td>
                                        <td>
                                        <s:password name="password" id="password" size="20" /></td>
                                    </tr>
                                </tbody>
                            </table>
                            <p class="fw dispC" align="center">
                                <input type="button" id="loginBtn" value="login" style="width: 80px;"/>
                            </p>
                            <span class="cb"> <span class="cl"></span>
                            </span>
                        </div>
                        <span class="sb"> <span class="sl"></span>
                        </span>
                    </div>
                </div>
                <br /> <br />
                <div align="center" id="login_error_message"></div>
            </div>
        </div>
        <div style="filter: dropshadow(color = #999999, offX = 1, offY = 1); text-align: right; position: absolute; bottom: 0; margin: 5px; font-family: Verdana; font-size: 10px;">
            <a href="#">SSH Sample</a>
        </div>
    </form>

</body>
</html>
