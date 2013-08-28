<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="tiles" uri="/tiles-tags" %>

<p id="fileUpLoadTitle">文件上传</p>
<p>
    <font color="red">
        <s:fielderror />
        <s:actionerror />
    </font>
    <s:actionmessage />
</p>

<s:form action="file-upload" method="POST" enctype="multipart/form-data">
    <table id="fileUploadTable">
        <tr>
            <th align="center">请选择文件</th>
            <td>
                <s:file name="updFile" />
            </td>
        </tr>
        <tr id="addTr">
            <td colspan="2" align="right">
                <input type="button" id="addBtn" value="添加" />
            </td>
        </tr>
    </table>
    <s:submit value="上传" method="exeUpload" />
</s:form>

