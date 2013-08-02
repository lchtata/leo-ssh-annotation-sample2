<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="tiles" uri="/tiles-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
String themeName = (String)session.getAttribute(edu.leo.common.CommonConst.SESSION_KEY_THEME);
%>
<tiles:insertDefinition name='<%=themeName %>'>
    <tiles:putAttribute name="originalJavascript">
        <script language="JavaScript" type="text/javascript">
            $(document).ready(function(){

                // jquery ui
                $("#commonResultTItle").leoStyleTitle();

                $("#returnBtn").click(function(){
                    var vUrl = $("#returnUrl").val();
                    window.location.href = vUrl;
                });
            });
        </script>
    </tiles:putAttribute>
    <tiles:putAttribute name="body" value="/WEB-INF/jsp/v_result.jsp" />
</tiles:insertDefinition>
