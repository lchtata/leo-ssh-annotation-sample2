<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="tiles" uri="/tiles-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
String themeName = (String)session.getAttribute(edu.leo.common.CommonConst.SESSION_KEY_THEME);
%>
<%--
<tiles:insertDefinition name='<s:property value="#session.SESSION_KEY_THEME" />'>
 --%>
<tiles:insertDefinition name='<%=themeName %>'>
    <tiles:putAttribute name="originalJavascript">
        <script language="JavaScript" type="text/javascript">
            $(document).ready(function(){
                //alert("main");
            });
        </script>
    </tiles:putAttribute>
    <tiles:putAttribute name="body" value="/WEB-INF/jsp/v_main.jsp" />
</tiles:insertDefinition>
