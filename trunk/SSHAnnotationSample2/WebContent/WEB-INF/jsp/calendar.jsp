<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="tiles" uri="/tiles-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
String themeName = (String)session.getAttribute(edu.leo.common.CommonConst.SESSION_KEY_THEME);
%>
<tiles:insertDefinition name='<%=themeName %>'>
    <tiles:putAttribute name="originalJavascript">
        <script language="JavaScript" type="text/javascript" src="js/jqueryui/i18n/jquery-ui-i18n.js"></script>
        <script language="JavaScript" type="text/javascript" src="js/calendar/calendar.js"></script>
        <script language="JavaScript" type="text/javascript">
            var vCalendarCallback = function(pSetObject, pYear, pMonth, pDay) {
                alert("回调函数  " + pSetObject.name + "  " + pYear + "  " + pMonth + "  " + pDay);
            }
            //jQuery Onload
            $(document).ready(function() {
                 // jquery ui
                $("#calendarTitle").leoStyleTitle();


                $("#dateTxt1").datepicker();

                $("#dateTxt2").datepicker();
                $("#formatSelect").change(function() {
                    $("#dateTxt2").datepicker("option", "dateFormat", $(this).val());
                });

                $("#dateTxt3").datepicker({ minDate: -20, maxDate: "+1M +10D" });
                $("#dateTxt3").datepicker("option", "dateFormat", "yy/mm/dd");

                $.datepicker.setDefaults( $.datepicker.regional[ "" ] );
                $("#dateTxt4").datepicker( $.datepicker.regional[ "fr" ] );
                $("#localeSelect4").change(function() {
                    $("#dateTxt4").datepicker("option", $.datepicker.regional[ $(this).val() ] );
                });

                $.datepicker.setDefaults( $.datepicker.regional[ "zh-CN" ] );
                $("#dateTxt5").datepicker({
                    altField: "#alternate5",
                    altFormat: "DD, d MM, yy"
                });

                $('#showDatepicker6').datepicker({inline: true});

                $("#dateTxt7").datepicker({showButtonPanel: true});

                $("#dateTxt8").datepicker({
                    changeMonth: true,
                    changeYear: true
                });

                $("#dateTxt9").datepicker({
                    showOtherMonths: true,
                    selectOtherMonths: true
                });

                $("#dateTxt10").datepicker({
                    showWeek: true,
                    firstDay: 1
                });

                $("#dateTxt11").datepicker({
                    numberOfMonths: 3,
                    showButtonPanel: true
                });

                $("#dateTxt12").datepicker({
                    showOn: "button",
                    buttonImage: "img/calendar.gif",
                    buttonImageOnly: true
                });

                $("#dateTxt13").datepicker();
                $("#anim13").change(function() {
                    $("#dateTxt13").datepicker( "option", "showAnim", $(this).val() );
                });

                var dates = $( "#from, #to" ).datepicker({
                    defaultDate: "+1w",
                    changeMonth: true,
                    numberOfMonths: 3,
                    onSelect: function( selectedDate ) {
                        var option = this.id == "from" ? "minDate" : "maxDate",	instance = $( this ).data( "datepicker" ), date = $.datepicker.parseDate(instance.settings.dateFormat || $.datepicker._defaults.dateFormat,	selectedDate, instance.settings );
                        dates.not( this ).datepicker( "option", option, date );
                    }
                });

                customMyDatapicker($("#myCustomTxt"));
            });

            function customMyDatapicker(pInputNode) {
                $.datepicker.setDefaults( $.datepicker.regional[ "ja" ] );
                pInputNode.datepicker({
                    showButtonPanel: true,
                    //changeMonth: true,
                    changeYear: true,
                    showOn: "button",
                    buttonImage: "img/calendar.gif",
                    buttonImageOnly: true
                });
                pInputNode.datepicker("option", "dateFormat", "yy/mm/dd");
                pInputNode.datepicker("option", "showAnim", "drop");
             }
        </script>
    </tiles:putAttribute>
    <tiles:putAttribute name="body" value="/WEB-INF/jsp/v_calendar.jsp" />
</tiles:insertDefinition>
