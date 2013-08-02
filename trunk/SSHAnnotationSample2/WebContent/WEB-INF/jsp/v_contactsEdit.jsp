<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="tiles" uri="/tiles-tags"%>

<p id="contactEditTitle">电话号码编辑</p>
<p>
    <font color="red">
        <s:fielderror />
        <s:actionerror />
    </font>
    <s:actionmessage />
</p>

<s:form id="contactEditForm" name="contactEditForm" method="post">

    <table>
        <tr>
            <td>
                <input type="button" id="updateBtn" value="更新">
            </td>
            <td>
                <input type="button" id="returnBtn" value="返回">
            </td>
        </tr>
    </table>
    <br>

    <table id="contactEditTable">
        <tr>
            <th style="width: 130px;">识别号：</th>
            <td>
                <s:property value="contactsSeq"/>
                <s:hidden name="contactsSeq"/>
                <s:hidden name="acctionType"/>
                <s:hidden name="updCnt"/>
            </td>
        </tr>
        <tr>
            <th>姓名（汉字）：</th>
            <td>
                姓：<s:textfield name="nameFamily" maxLength="10" size="10" cssStyle="width:130px" />
                名：<s:textfield name="nameGiven" maxLength="10" size="10" cssStyle="width:130px" />
            </td>
        </tr>
        <tr>
            <th>姓名（拼音）：</th>
            <td>
                姓：<s:textfield name="nameFamilyPhonetic" maxLength="10" size="10" cssStyle="width:130px"  />
                名：<s:textfield name="nameGivenPhonetic" maxLength="10" size="10" cssStyle="width:130px"  />
            </td>
        </tr>
        <tr>
           <th>昵称：</th>
           <td >
               <s:textfield name="nickName" maxLength="10" size="10" cssStyle="width:130px"  />
           </td>
        </tr>
        <tr>
           <th>电话号码：</th>
           <td>
               <span id="addPhoneIcon" class='ui-icon ui-icon-circle-plus'></span>
               <table id="phoneListTbl"></table>
           </td>
        </tr>
        <tr>
            <th>备忘：</th>
            <td>
                <s:textarea name="note" cssStyle="width:500px; height:50px;" />
            </td>
        </tr>
        <tr>
           <th>个人主页：</th>
           <td>
                <s:textfield name="websiteUrl" maxLength="30" size="30" cssStyle="width: 500px; ime-mode: disabled;"  />
           </td>
        </tr>
    </table>

<br/>
</s:form>

<s:form id="toListForm" name="toListForm" method="post">
</s:form>

<br />
<br />
