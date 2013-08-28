<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="tiles" uri="/tiles-tags"%>

<p id="calendarTitle">日历示例</p>
<div align="center">
    <br>
    <h2>梅花雨日历</h2>
    <table>
        <tr>
            <td>请选择日期(使用callback) 请保证图片和日期输入框在一个td中</td>
            <td>
                <input type="text" name="txtCal" size="12" maxlength="12" onclick="javascript:calendar('txtCal', vCalendarCallback);" />
                <img onclick="javascript:calendar('txtCal', vCalendarCallback);" src="img/calandar.bmp" alt='' class="img_hand">
            </td>
        </tr>
        <tr>
            <td>请选择日期(不使用callback) 请保证图片和日期输入框在一个td中</td>
            <td>
                <input type="text" name="txtCal" size="12" maxlength="12" onclick="javascript:calendar('txtCal');" />
                <img onclick="javascript:calendar('txtCal');" src="img/calandar.bmp" alt='' class="img_hand">
            </td>
        </tr>
    </table>
    <br>
    <hr color="red">
    <br>
    <br>
    <h2>Struts2 Date Picker</h2>
    <table>
        <tr>
            <td>1.默认</td>
            <td>
                <s:set name="dt" value="new java.util.Date()"></s:set>
                <sx:datetimepicker label="birthday" name="bir" value="#dt"></sx:datetimepicker>
            </td>
        </tr>
        <tr>
            <td>2.格式化</td>
            <td>
                <sx:datetimepicker label="购买日期" name="buyDay"
                    displayFormat="yyyy年MM月dd日"></sx:datetimepicker>
            </td>
        </tr>
        <tr>
            <td>3.指定了weekStartsOn属性</td>
            <td>
                <sx:datetimepicker label="购买日期" name="buyDay"
                    displayFormat="yyyy/MM/dd" weekStartsOn="2"></sx:datetimepicker>
            </td>
        </tr>
    </table>
    <br>
    <br>
    <hr color="red">
    <br> <br>
    <h2>jQuery Date Picker</h2>

    <table cellpadding="3" border="1">
        <tr>
         <td>1.普通调用</td>
         <td>Date: <input type="text" id="dateTxt1"></td>
        </tr>
        <tr>
            <td>2.格式化调用</td>
            <td>Date: <input type="text" id="dateTxt2"><br>
            <select id="formatSelect">
                <option value="mm/dd/yy">Default - mm/dd/yy</option>
                <option value="yy/mm/dd">china - yy/mm/dd</option>
                <option value="yy-mm-dd">ISO 8601 - yy-mm-dd</option>
                <option value="d M, y">Short - d M, y</option>
                <option value="d MM, y">Medium - d MM, y</option>
                <option value="DD, d MM, yy">Full - DD, d MM, yy</option>
                <option value="'day' d 'of' MM 'in the year' yy">With text - 'day' d 'of' MM 'in the year' yy</option>
            </select>
            </td>
        </tr>
        <tr>
         <td>3.指定可选范围</td>
         <td>Date: <input type="text" id="dateTxt3"></td>
        </tr>
        <tr>
            <td>4.多语言对应</td>
            <td>
            Date: <input type="text" id="dateTxt4"><br>
            <select id="localeSelect4">
                <option value="af">Afrikaans</option>
                <option value="sq">Albanian (Gjuha shqipe)</option>
                <option value="ar-DZ">Algerian Arabic</option>
                <option value="ar">Arabic (&#8235;(&#1604;&#1593;&#1585;&#1576;&#1610;</option>
                <option value="hy">Armenian (&#1344;&#1377;&#1397;&#1381;&#1408;&#1381;&#1398;)</option>
                <option value="az">Azerbaijani (Az&#601;rbaycan dili)</option>
                <option value="eu">Basque (Euskara)</option>
                <option value="bs">Bosnian (Bosanski)</option>
                <option value="bg">Bulgarian (&#1073;&#1098;&#1083;&#1075;&#1072;&#1088;&#1089;&#1082;&#1080; &#1077;&#1079;&#1080;&#1082;)</option>
                <option value="ca">Catalan (Catal&agrave;)</option>
                <option value="zh-HK">Chinese Hong Kong (&#32321;&#39636;&#20013;&#25991;)</option>
                <option value="zh-CN">Chinese Simplified (&#31616;&#20307;&#20013;&#25991;)</option>
                <option value="zh-TW">Chinese Traditional (&#32321;&#39636;&#20013;&#25991;)</option>
                <option value="hr">Croatian (Hrvatski jezik)</option>
                <option value="cs">Czech (&#269;e&#353;tina)</option>
                <option value="da">Danish (Dansk)</option>
                <option value="nl">Dutch (Nederlands)</option>
                <option value="en-AU">English/Australia</option>
                <option value="en-NZ">English/New Zealand</option>
                <option value="en-GB">English/UK</option>
                <option value="eo">Esperanto</option>
                <option value="et">Estonian (eesti keel)</option>
                <option value="fo">Faroese (f&oslash;royskt)</option>
                <option value="fa">Farsi/Persian (&#8235;(&#1601;&#1575;&#1585;&#1587;&#1740;</option>
                <option value="fi">Finnish (suomi)</option>
                <option value="fr" selected="selected">French (Fran&ccedil;ais)</option>
                <option value="fr-CH">French/Swiss (Fran&ccedil;ais de Suisse)</option>
                <option value="gl">Galician</option>
                <option value="de">German (Deutsch)</option>
                <option value="el">Greek (&#917;&#955;&#955;&#951;&#957;&#953;&#954;&#940;)</option>
                <option value="he">Hebrew (&#8235;(&#1506;&#1489;&#1512;&#1497;&#1514;</option>
                <option value="hu">Hungarian (Magyar)</option>
                <option value="is">Icelandic (&Otilde;slenska)</option>
                <option value="id">Indonesian (Bahasa Indonesia)</option>
                <option value="it">Italian (Italiano)</option>
                <option value="ja">Japanese (&#26085;&#26412;&#35486;)</option>
                <option value="ko">Korean (&#54620;&#44397;&#50612;)</option>
                <option value="kz">Kazakhstan (Kazakh)</option>
                <option value="lv">Latvian (Latvie&ouml;u Valoda)</option>
                <option value="lt">Lithuanian (lietuviu kalba)</option>
                <option value="ml">Malayalam</option>
                <option value="ms">Malaysian (Bahasa Malaysia)</option>
                <option value="no">Norwegian (Norsk)</option>
                <option value="pl">Polish (Polski)</option>
                <option value="pt">Portuguese (Portugu&ecirc;s)</option>
                <option value="pt-BR">Portuguese/Brazilian (Portugu&ecirc;s)</option>
                <option value="rm">Rhaeto-Romanic (Romansh)</option>
                <option value="ro">Romanian (Rom&acirc;n&#259;)</option>
                <option value="ru">Russian (&#1056;&#1091;&#1089;&#1089;&#1082;&#1080;&#1081;)</option>
                <option value="sr">Serbian (&#1089;&#1088;&#1087;&#1089;&#1082;&#1080; &#1112;&#1077;&#1079;&#1080;&#1082;)</option>
                <option value="sr-SR">Serbian (srpski jezik)</option>
                <option value="sk">Slovak (Slovencina)</option>
                <option value="sl">Slovenian (Slovenski Jezik)</option>
                <option value="es">Spanish (Espa&ntilde;ol)</option>
                <option value="sv">Swedish (Svenska)</option>
                <option value="ta">Tamil (&#2980;&#2990;&#3007;&#2996;&#3021;)</option>
                <option value="th">Thai (&#3616;&#3634;&#3625;&#3634;&#3652;&#3607;&#3618;)</option>
                <option value="tj">Tajikistan</option>
                <option value="tr">Turkish (T&uuml;rk&ccedil;e)</option>
                <option value="uk">Ukranian (&#1059;&#1082;&#1088;&#1072;&#1111;&#1085;&#1089;&#1100;&#1082;&#1072;)</option>
                <option value="vi">Vietnamese (Ti&#7871;ng Vi&#7879;t)</option>
            </select>
            </td>
        </tr>
        <tr>
            <td>5.格式化输出</td>
            <td>Date: <input type="text" id="dateTxt5"><br>
                <input type="text" id="alternate5" size="30"/>
            </td>
        </tr>
        <tr>
            <td>6.直接表示</td>
            <td>Date:<div id="showDatepicker6"></div>
            </td>
        </tr>
        <tr>
            <td>7.表示按钮</td>
            <td>Date: <input type="text" id="dateTxt7"></td>
        </tr>
        <tr>
            <td>8.年和月可选择</td>
            <td>Date: <input type="text" id="dateTxt8"></td>
        </tr>
        <tr>
            <td>9.显示上月和下月的日期（补位）</td>
            <td>Date: <input type="text" id="dateTxt9"></td>
        </tr>
        <tr>
            <td>10.显示本年的第几周</td>
            <td>Date: <input type="text" id="dateTxt10"></td>
        </tr>
        <tr>
            <td>11.显示多个月</td>
            <td>Date: <input type="text" id="dateTxt11"></td>
        </tr>
        <tr>
            <td>12.日历按钮</td>
            <td>Date: <input type="text" id="dateTxt12"></td>
        </tr>
        <tr>
            <td>13.日历弹出方式</td>
            <td>Date: <input type="text" id="dateTxt13"><br>
            <select id="anim13">
                <option value="show">Show (default)</option>
                <option value="slideDown">Slide down</option>
                <option value="fadeIn">Fade in</option>
                <option value="blind">Blind (UI Effect)</option>
                <option value="bounce">Bounce (UI Effect)</option>
                <option value="clip">Clip (UI Effect)</option>
                <option value="drop">Drop (UI Effect) i like</option>
                <option value="fold">Fold (UI Effect)</option>
                <option value="slide">Slide (UI Effect)</option>
                <option value="">None</option>
            </select>
            </td>
        </tr>
        <tr>
            <td>14.开始结束模板</td>
            <td>Date:
                <label for="from">From</label><input type="text" id="from" name="from"/>
                <label for="to">to</label><input type="text" id="to" name="to"/>
            </td>
        </tr>
    </table>
    <br>
    <br>
    我的定制：<input type="text" id="myCustomTxt">
    <br> <br>
    <a href="http://jqueryui.com/demos/datepicker/">更多请参照jQuery主页</a>
    <br> <br>
</div>

