<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="tiles" uri="/tiles-tags"%>

<p class="leo_title">电话号码一览</p>
<p>
    <font color="red">
        <s:fielderror />
        <s:actionerror />
    </font>
    <s:actionmessage />
</p>

<s:form id="contactListForm" name="contactListForm" method="post">
    <%--paging item setting --%>
    <s:hidden name="pageCount" />
    <s:hidden name="pageNum" />

    <table class="leo_view">
        <tr>
            <th style="width: 130px;">姓名：</th>
            <td><s:textfield name="srchName" id="srchName" /></td>
        </tr>
    </table>
    <table>
        <tr>
            <td>
                <input type="button" id="searchBtn" value="查询">
            </td>
            <td>
                <input type="button" id="newBtn" value="新建">
            </td>
            <td>
                <input type="button" id="deleteBtn" value="删除">
            </td>
        </tr>
    </table>
<br/>
</s:form>

<s:form id="toEditForm" name="toEditForm" method="post">
    <input type="hidden" id="acctionType" name="acctionType" value="">
    <input type="hidden" id="contactsSeq" name="contactsSeq" value="">
</s:form>

<table>
    <s:if test="showResult">
        <tr>
            <td>

    <table>
        <tr>
            <td>
                <table style="width: 680px">
                    <tr>
                        <td align="center">
                            <s:if test="pageNum > 1">
                                <%--
                                <a href="<s:url action="contacts-list" method="gotoFirst"/>">最初ページ</a>
                                --%>
                                <a href="javascript:void(0);" onclick="javascript:gotoFirst();">首页</a>
                            </s:if>
                            <s:else>
                                首页
                            </s:else>
                            &nbsp;&nbsp;&nbsp;&nbsp;
                            <s:if test="pageNum > 1">
                                <a href="javascript:void(0);" onclick="javascript:gotoPrev();">上一页</a>
                            </s:if>
                            <s:else>
                                上一页
                            </s:else>
                            &nbsp;&nbsp;&nbsp;&nbsp;
                            当前表示：<s:property value="count" />条
                            &nbsp;&nbsp;&nbsp;&nbsp;
                            页数：<s:property value="pageNum" />/<s:property value="pageCount" />
                            &nbsp;&nbsp;&nbsp;&nbsp;
                            <s:if test="pageNum < pageCount">
                                <a href="javascript:void(0);" onclick="javascript:gotoNext();">下一页</a>
                            </s:if>
                            <s:else>
                                下一页
                            </s:else>
                            &nbsp;&nbsp;&nbsp;&nbsp;
                            <s:if test="pageNum < pageCount">
                                <a href="javascript:void(0);" onclick="javascript:gotoLast();">末页</a>
                            </s:if>
                            <s:else>
                                末页
                            </s:else>
                        </td>
                    </tr>
                </table>
            </td>
        </tr>
        <tr>
            <td><br /></td>
        </tr>
        <tr>
            <td>
                <table class="leo_table" style="width: 680px; word-break: break-all;">
                    <tr>
                        <th width="20px">#</th>
                        <th width="120px">修改</th>
                        <th>姓名</th>
                        <th>备考</th>
                        <th width="30px">删除</th>
                    </tr>
                    <s:iterator value="contactsList" id="element" status="stt">
                        <tr style="text-align: left;">
                            <%--#--%>
                            <td style="text-align: center;">
                                <s:property value="firstResult + #stt.count" />
                            </td>
                            <%--修改--%>
                            <td style="text-align: center;">
                                <input type="button" name="updateBtn" value="修改">
                                <input type="button" name="detailBtn" value="详细">
                                <input type="hidden" name="hidContactsSeq" value='<s:property value="#element.contactsSeq"/>'>
                            </td>
                            <%--姓名--%>
                            <td style="text-align: center;">
                                <s:property value="#element.name" />
                            </td>
                            <%--备考--%>
                            <td>
                                <s:property value="#element.note" />&nbsp;
                            </td>
                            <%--删除--%>
                            <td style="text-align: center;">
                                <input type="checkbox">
                            </td>
                        </tr>
                    </s:iterator>
                </table>
            </td>
        </tr>
    </table>

            </td>
        </tr>
    </s:if>
</table>
<br />
<br />


<iframe id="contactsListPopupFrame" style="display: none"></iframe>
