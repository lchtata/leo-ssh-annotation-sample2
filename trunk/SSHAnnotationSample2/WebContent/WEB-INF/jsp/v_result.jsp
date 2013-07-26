<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="tiles" uri="/tiles-tags"%>

<p class="leo_title">処理完成</p>
<p>
    <font color="red">
        <s:fielderror />
        <s:actionerror />
    </font>
    <s:actionmessage />
</p>

<p style="margin-top:30px;margin-left:10px;">
    <input type="button" id="returnBtn" class="backButton" value="返回" style="width:80px;"/>
    <s:hidden id="returnUrl" name="returnUrl" />
</p>
