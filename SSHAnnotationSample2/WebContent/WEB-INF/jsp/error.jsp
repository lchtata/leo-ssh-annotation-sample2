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

        $("#gotoLogin").click(function(){
            var openMode = 1;
            if (window.opener != null) {
                openMode = 2;
            } else if (parent.window != null) {
                openMode = 2;
            } else {
                openMode = 1;
            }

            var vUrl = "login.action";
            if (openMode == 1) {
                // 正常模式
                window.location.href = vUrl;
            } else {
                // 子画面模式
                //self.parent.$('#contactsListPopupFrame').dialog("close");
                self.parent.window.location.href = vUrl;
            }
        });
    });
</script>
</head>
<body>
抱歉，服务器内部错误。<br>
<input type="button" id="gotoLogin" value="重新登陆" style="width:120px;" /><br>

<!--
<s:property value="exception.message"/>
 -->
<p>
<s:property value="exceptionStack"/>
</p>

<p>
<%--
<s:debug />
  --%>
</p>


</body>
</html>
