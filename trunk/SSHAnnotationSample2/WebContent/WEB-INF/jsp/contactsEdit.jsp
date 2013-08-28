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

            // 電番行番号
            var phoneListRowId = -1;

            $(document).ready(function(){
                //alert("contactsEdit");

                // jquery ui
                $("#contactEditTitle").leoStyleTitle();
                $("#contactEditTable").leoStyleTable({oddRowColor: false});

                /**
                 * update button
                 */
                $("#updateBtn").click(function(){
                    if(confirm("是否更新？")){
                        showLoading();

                        var contactEditForm = $("#contactEditForm");
                        contactEditForm.attr("action", "contacts-edit!update.action");
                        contactEditForm.submit();
                    }
                });

                /**
                 * return button
                 */
                $("#returnBtn").click(function(){
                    if(confirm("您现在有编辑中的内容，是否放弃编辑返回？")){
                        showLoading();

                        var toListForm = $("#toListForm");
                        toListForm.attr("action", "contacts-list.action");
                        toListForm.submit();
                    }
                });

                // 電番情報の新規作成ボタンのクリックイベント
                $("#addPhoneIcon").click(function() {
                    addPhoneListInfo(null);
                });

                // ～情報の初期化
                initListInfo();
            });

            /**
             * TRを新規作成
             */
            function createTr() {
                var tr = $('<tr></tr>');
                return tr;
            }

            /**
             * TDを新規作成
             */
            function createTd() {
                var td = $('<td></td>');
                return td;
            }

            /**
             * SPANを新規作成
             */
            function createSpan() {
                var span = $('<span></span>');
                return span;
            }

            /**
             * INPUTを新規作成
             */
            function createInput() {
                var input = $('<input></input>');
                return input;
            }

            /**
             * MINUSボタンを新規作成
             */
            function createMinusButton() {
                var minusButton = $("<span class='ui-icon ui-icon-circle-minus'></span>");
                minusButton.attr("id","delIcon");
                minusButton.click(function() {
                    delListInfo($(this));
                });
                return minusButton;
            }

            /**
             * MINUSボタンを押下した時に、該当一行を削除する
             */
            function delListInfo(pDelBtn) {
                if(confirm("确定删除吗？")){
                    // 該当TRを取得する
                    var vTargetTr = pDelBtn.parent().parent();
                    // 削除
                    vTargetTr.remove();
                }
            }

            /**
             * 電番分類を新規作成
             */
            function getPhoneTypeSelect() {
                var phoneTypeSelect = $("<select id='type'></select>");
                // オプションを追加する
                phoneTypeSelect.append("<option value='0'>自定义</option>");
                phoneTypeSelect.append("<option value='1'>家庭</option>");
                phoneTypeSelect.append("<option value='2'>手机</option>");
                phoneTypeSelect.append("<option value='3'>公司</option>");
                phoneTypeSelect.append("<option value='4'>公司传真</option>");
                phoneTypeSelect.append("<option value='5'>家庭传真</option>");
                phoneTypeSelect.append("<option value='7'>其他</option>");
                // デフォルトが「携帯」を選択する
                phoneTypeSelect.val('2');
                return phoneTypeSelect;
            }

            /**
             * 分類を変更した時に
             * カスタム項目かどうかを判断し、ラベル項目の表示/非表示
             */
            function typeChanged(typeSelect) {
                // 分類
                var type = typeSelect.val();
                var vTargetTr = typeSelect.parent().parent();
                // カスタムSpan
                var customSpan = vTargetTr.find("span[id='customSpan']");
                // カスタムinput
                var customInput = vTargetTr.find("input[id='customInput']");
                if (type == '0') {
                    // 「カスタム」の場合
                    customSpan.attr('style', 'display: inline;');
                    customInput.attr('style', 'display: inline;');
                } else {
                    // 「カスタム」以外の場合
                    customSpan.attr('style', 'display: none;');
                    customInput.attr('style', 'display: none;');
                    customInput.val('');
                }
            }

            /**
             * 情報の初期化
             * modelのList属性から受け取る
             */
            function initListInfo() {

                // modelのphoneList属性から受け取る
                <s:iterator value="phoneList" id="element" status="stt">
                    addPhoneListInfo(
                                    {
                                        phoneType : '<s:property value="#element.phoneType"/>'
                                        ,phoneLabel : '<s:property value="@edu.leo.common.util.StringUtilEx@escapeForJS(#element.phoneLabel)" escape="false" />'
                                        ,phoneNumber : '<s:property value="@edu.leo.common.util.StringUtilEx@escapeForJS(#element.phoneNumber)" escape="false" />'
                                    }
                    );
                </s:iterator>

            }

            /**
             * 電番情報を新規作成
             * [table]phoneListTblに新たしいTRを追加する
             *
             * @param phoneInfo 電番情報のjsonデータ[null:新規作成/nullじゃない:初期化]
             */
            function addPhoneListInfo(phoneInfo) {
                // 最大行数の制御
                if ($("#phoneListTbl").find("tr").length > 6) {
                   alert("无法继续添加，只能加7行。");
                   return false;
                }

                // 行番号を追加
                phoneListRowId++;

                // TRを作成
                var newTr = createTr();
                // TDを作成
                var newTd = createTd();

                // 電番分類を作成し、TDに追加
                var phoneTypeSelect = getPhoneTypeSelect();
                // 名称例：phoneList[1].phoneType
                phoneTypeSelect.attr("name", "phoneList[" + phoneListRowId + "].phoneType");
                phoneTypeSelect.change(function() {
                    typeChanged($(this));
                });
                if (phoneInfo != null) {
                    phoneTypeSelect.val(phoneInfo.phoneType);
                }
                phoneTypeSelect.appendTo(newTd);

                // カスタムSpanを作成し、TDに追加
                var customSpan = createSpan();
                customSpan.text("自定义名：");
                customSpan.attr('id', 'customSpan');
                customSpan.attr('style', 'display: none;');
                customSpan.appendTo(newTd);

                // カスタムinputを作成し、TDに追加
                var phoneLabelInput = createInput();
                // 名称例：phoneList[1].phoneLabel
                phoneLabelInput.attr('id', 'customInput');
                phoneLabelInput.attr("name", "phoneList[" + phoneListRowId + "].phoneLabel");
                phoneLabelInput.attr("size","20");
                phoneLabelInput.attr("maxLength","20");
                phoneLabelInput.attr('style', 'display: none; width:190px;');
                if (phoneInfo != null) {
                    phoneLabelInput.val(phoneInfo.phoneLabel);
                }
                phoneLabelInput.appendTo(newTd);

                // 番号Spanを作成し、TDに追加
                var phoneNumberSpan = createSpan();
                phoneNumberSpan.text(" 号码：");
                phoneNumberSpan.appendTo(newTd);

                // 番号Inputを作成し、TDに追加
                var phoneNumberInput = createInput();
                // 名称例：phoneList[1].phoneNumber
                phoneNumberInput.attr("name", "phoneList[" + phoneListRowId + "].phoneNumber");
                phoneNumberInput.attr("size","11");
                phoneNumberInput.attr("maxLength","11");
                if (phoneInfo != null) {
                    phoneNumberInput.val(phoneInfo.phoneNumber);
                }
                phoneNumberInput.appendTo(newTd);

                // MINUSボタンを作成し、TDに追加
                var minusButton = createMinusButton();
                var minusButtonTd = createTd();
                minusButton.appendTo(minusButtonTd);

                // [table]phoneListTblに追加する
                newTd.appendTo(newTr);
                minusButtonTd.appendTo(newTr);
                newTr.appendTo("#phoneListTbl");

                // 電番分類の変更イベントを行う
                phoneTypeSelect.trigger("change");
            }
        </script>
    </tiles:putAttribute>
    <tiles:putAttribute name="body" value="/WEB-INF/jsp/v_contactsEdit.jsp" />
</tiles:insertDefinition>
