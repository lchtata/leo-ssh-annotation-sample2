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
        // jquery ui
        $("input[type='button']").button();
    });
</script>

<%--insert jsp javascript here --%>
<tiles:insertAttribute name="originalJavascript" />

</head>
<body>

    <table class="layout_table">
        <tr>
            <td style="text-align:right;">
                <%--Header--%>
            </td>
        </tr>
        <tr>
            <td>
                <%--Menu--%>
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
