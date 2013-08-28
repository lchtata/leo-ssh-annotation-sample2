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
                $("#fileUpLoadTitle").leoStyleTitle();
                $("#fileUploadTable").leoStyleTable({oddRowColor: false});

                $("#addBtn").click(function(){
                    // 复制第一个tr
                    var tr = $("#fileUploadTable tr").eq(0).clone();
                    tr.appendTo("#fileUploadTable");
                    // 在[添加button的tr]之前加入新建的tr
                    var vAddTr = $("#addTr");
                    tr.insertBefore(vAddTr);
                });
            });
        </script>
    </tiles:putAttribute>
    <tiles:putAttribute name="body" value="/WEB-INF/jsp/v_fileUpload.jsp" />
</tiles:insertDefinition>
