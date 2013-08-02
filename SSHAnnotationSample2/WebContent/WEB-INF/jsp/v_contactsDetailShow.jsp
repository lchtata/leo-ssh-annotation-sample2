<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="tiles" uri="/tiles-tags"%>

<p id="contactDetailTitle">详细一览</p>
<p>
    <font color="red">
        <s:fielderror />
        <s:actionerror />
    </font>
    <s:actionmessage />
</p>

<table id="contactDetailHeaderTable">
    <tr>
        <th style="width: 130px;">
            识别号：
        </th>
        <td style="width: 330px;">
            <s:property value="headerInfo.contactsSeq" />
        </td>
    </tr>
    <tr>
        <th>
            名字：
        </th>
        <td>
            <s:property value="headerInfo.name" />
        </td>
    </tr>
    <tr>
        <th>
            昵称：
        </th>
        <td>
            <s:property value="headerInfo.nickName" />
        </td>
    </tr>
    <tr>
        <th>
            备注：
        </th>
        <td>
            <s:property value="headerInfo.note.replaceAll('\r\n','<br/>')" escapeHtml="false" />
        </td>
    </tr>
    <tr>
        <th>
            网址：
        </th>
        <td>
            <s:property value="headerInfo.websiteUrl" />
        </td>
    </tr>
</table>

<br>

<table id="contactDetailDetailTable" style="width: 680px; word-break: break-all;">
    <tr>
        <th width="20px">#</th>
        <th>电话类别</th>
        <th>自定义名</th>
        <th>电话号码</th>
    </tr>
    <s:iterator value="phoneList" id="element" status="stt">
        <tr style="text-align: left;">
            <%--#--%>
            <td style="text-align: center;">
                <s:property value="#stt.count" />
            </td>
            <%--电话类别--%>
            <td style="text-align: center;">
                <s:property value="#element.phoneType" />
            </td>
            <%--自定义名--%>
            <td>
                <s:property value="#element.phoneLabel" />
            </td>
            <%--电话号码--%>
            <td style="text-align: right;">
                <s:property value="#element.phoneNumber" />
            </td>
        </tr>
    </s:iterator>
</table>

