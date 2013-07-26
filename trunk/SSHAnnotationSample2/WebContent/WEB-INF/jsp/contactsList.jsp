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

            var ACTION_TYPE_NEW = "0";
            var ACTION_TYPE_EDIT = "1";

            $(document).ready(function(){
                //alert("contactsList");

                $("#searchBtn").click(function(){
                    var contactListForm = $("#contactListForm");
                    contactListForm.attr("action", "contacts-list.action");
                    contactListForm.submit();
                });

                $("#newBtn").click(function(){
                    $("#acctionType").val(ACTION_TYPE_NEW);
                    var toEditForm = $("#toEditForm");
                    toEditForm.attr("action", "contacts-edit.action");
                    toEditForm.submit();
                });

                $("input[name='updateBtn']").click(function(){
                    $("#acctionType").val(ACTION_TYPE_EDIT);
                    var selectedSeq = $(this).parent().find("input[name=hidContactsSeq]").val();
                    $("#contactsSeq").val(selectedSeq);
                    var toEditForm = $("#toEditForm");
                    toEditForm.attr("action", "contacts-edit.action");
                    toEditForm.submit();
                });

                $("input[name='detailBtn']").click(function(){
                    var selectedSeq = $(this).parent().find("input[name=hidContactsSeq]").val();
                    popupShowDetail(selectedSeq);
                });
            });

            function gotoFirst(){
                var contactListForm = $("#contactListForm");
                contactListForm.attr("action", "contacts-list!gotoFirst.action");
                contactListForm.submit();
            }

            function gotoPrev(){
                var contactListForm = $("#contactListForm");
                contactListForm.attr("action", "contacts-list!gotoPrev.action");
                contactListForm.submit();
            }

            function gotoNext(){
                var contactListForm = $("#contactListForm");
                contactListForm.attr("action", "contacts-list!gotoNext.action");
                contactListForm.submit();
            }

            function gotoLast(){
                var contactListForm = $("#contactListForm");
                contactListForm.attr("action", "contacts-list!gotoLast.action");
                contactListForm.submit();
            }

            function popupShowDetail(contactsSeq){
                var horizontalPadding = 30;
                var verticalPadding   = 30;
                var maxWidth = 800;
                var maxHeight = 600;

                var vUrl = 'contacts-detail-show.action?contactsSeq='+ contactsSeq;
                $('#contactsListPopupFrame').attr('src', vUrl);

                //$('#contactsListPopupFrame').dialog("destroy");
                $('#contactsListPopupFrame').dialog({
                    title: '详细',
                    autoOpen: true,
                    //dialogClass: "no-close",
                    width:  maxWidth,
                    height: maxHeight,
                    modal: true,
                    resizable:  false,
                    autoResize: true,
                    overlay: {
                        opacity: 0.5,
                        background: "black"
                    },
                    buttons: {
                        '取消': function() {
                            $(this).dialog("close");
                        }
                    },
                    beforeClose: function( event, ui ) {
                        //alert("beforeClose");
                    },
                    close: function( event, ui ) {
                        $('#contactsListPopupFrame').attr('src', '');
                    }
                }).width(maxWidth - horizontalPadding).height(maxHeight - verticalPadding);
            }

        </script>
    </tiles:putAttribute>
    <tiles:putAttribute name="body" value="/WEB-INF/jsp/v_contactsList.jsp" />
</tiles:insertDefinition>
