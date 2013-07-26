package edu.leo.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public final class DateUtil {

    /** Log */
    protected static Log log = LogFactory.getLog(DateUtil.class);

    /**
     * 日付表示タイプ
     */
    /** 日付タイプ:yyyy/MM/dd HH:mm:ss. */
    public static final String TYPE_YMDHMS_WITH_SEP = "yyyy/MM/dd HH:mm:ss";
    /** 日付タイプ:yyyy-MM-dd HH:mm:ss. */
    public static final String TYPE_YMDHMS_WITH_HYP = "yyyy-MM-dd HH:mm:ss";
    /** 日付タイプ:yyyy/MM/dd h:mm:ss. */
    public static final String TYPE_YMD1HMS_WITH_SEP = "yyyy/MM/dd h:mm:ss";
    /** 日付タイプ:yyyyMMdd HHmmss. */
    public static final String TYPE_YMDHMS = "yyyyMMdd HHmmss";
    /** 日付タイプ:yyyyMMddHHmmss. */
    public static final String TYPE_YMDHMS_NO_SPACE = "yyyyMMddHHmmss";
    /** 日付タイプ:yyyy/MM/dd. */
    public static final String TYPE_YMD_WITH_SEP = "yyyy/MM/dd";
    /** 日付タイプ:yyyy-MM-dd. */
    public static final String TYPE_YMD_WITH_HYP = "yyyy-MM-dd";
    /** 日付タイプ:yyyyMMdd. */
    public static final String TYPE_YMD = "yyyyMMdd";
    /** 日付タイプ:yyyy年MM月dd日. */
    public static final String TYPE_YMD_JP = "yyyy年MM月dd日";
    /** 日付タイプ:yyyy/MM/dd HH時mm分ss秒. */
    public static final String TYPE_YMDHMS_JP = "yyyy/MM/dd HH時mm分ss秒";
    /** 日付タイプ:yyyyMM. */
    public static final String TYPE_YM = "yyyyMM";
    /** 日付タイプ:yyyy/MM. */
    public static final String TYPE_YM_WITH_SEP = "yyyy/MM";

    /** 日付表示タイプリスト. */
    public static final List<String> typeList;
    static {
        List<String> list = new ArrayList<String>();
        list.add(TYPE_YMDHMS_WITH_SEP);
        list.add(TYPE_YMDHMS_WITH_HYP);
        list.add(TYPE_YMD1HMS_WITH_SEP);
        list.add(TYPE_YMDHMS);
        list.add(TYPE_YMDHMS_NO_SPACE);
        list.add(TYPE_YMD_WITH_SEP);
        list.add(TYPE_YMD_WITH_HYP);
        list.add(TYPE_YMD);
        list.add(TYPE_YMD_JP);
        list.add(TYPE_YMDHMS_JP);
        list.add(TYPE_YM);
        list.add(TYPE_YM_WITH_SEP);

        typeList = Collections.unmodifiableList(list);
    }

    public static Date toDate(String dateString) {
        return toDate(dateString, typeList);
    }

    public static Date toDate(String dateString, List<String> formatList) {
        if (!StringUtils.hasText(dateString)) {
            return DateUtil.getCurrentDate();
        }

        String srcDate = dateString.replaceAll("/", "").replaceAll("-", "").replaceAll(":", "");

        StringTokenizer st = new StringTokenizer(srcDate, " ");
        if (st != null && st.countTokens() != 1) {
            String tmpYmd = st.nextToken();
            String tmpHms = st.nextToken();

            if (tmpHms.length() == 5) { // Hmmssの形
                tmpHms = "0" + tmpHms;
            } else if (tmpHms.length() == 7) { // Hmmss.sの形
                tmpHms = "0" + tmpHms.substring(0, 5);
            } else if (tmpHms.length() == 8) { // HHmmss.sの形
                tmpHms = tmpHms.substring(0, 6);
            }

            srcDate = tmpYmd + tmpHms;
        }
        if (srcDate != null && srcDate.length() == 6) {
            srcDate = srcDate + "01";
        }

        Date rtnValue = null;
        Calendar cal = DateUtil.getCurrentCalendar();
        ;
        int yyyy = 0;
        int mm = 0;
        int dd = 0;
        int hh = 0;
        int mi = 0;
        int ss = 0;

        if (srcDate.length() == 8) {
            yyyy = Integer.parseInt(srcDate.substring(0, 4));
            mm = Integer.parseInt(srcDate.substring(4, 6));
            dd = Integer.parseInt(srcDate.substring(6, 8));

            cal.set(Calendar.YEAR, yyyy);
            cal.set(Calendar.MONTH, mm - 1);
            cal.set(Calendar.DAY_OF_MONTH, dd);
            cal.set(Calendar.HOUR_OF_DAY, 0);
            cal.set(Calendar.MINUTE, 0);
            cal.set(Calendar.MILLISECOND, 0);

            cal.set(Calendar.SECOND, 0);

            rtnValue = cal.getTime();
        } else if (srcDate.length() == 14) {
            yyyy = Integer.parseInt(srcDate.substring(0, 4));
            mm = Integer.parseInt(srcDate.substring(4, 6));
            dd = Integer.parseInt(srcDate.substring(6, 8));
            hh = Integer.parseInt(srcDate.substring(8, 10));
            mi = Integer.parseInt(srcDate.substring(10, 12));
            ss = Integer.parseInt(srcDate.substring(12, 14));

            cal.set(Calendar.YEAR, yyyy);
            cal.set(Calendar.MONTH, mm - 1);
            cal.set(Calendar.DAY_OF_MONTH, dd);
            cal.set(Calendar.HOUR_OF_DAY, hh);
            cal.set(Calendar.MINUTE, mi);
            cal.set(Calendar.SECOND, ss);

            rtnValue = cal.getTime();
        } else {
            for (String typeString : formatList) {
                SimpleDateFormat sdf = new SimpleDateFormat(typeString);

                try {
                    Date dt = sdf.parse(dateString);

                    if (dateString.equals(sdf.format(dt))) {
                        rtnValue = dt;
                        break;
                    }

                } catch (ParseException pe) {
                    continue;
                }
            }

            if (rtnValue == null) {
                log.info("オブジェクトの日付変換処理に失敗しました。src=" + dateString);
            }
        }

        return rtnValue;
    }

    public static String toString(Date date, String type) {

        SimpleDateFormat sdf = new SimpleDateFormat(type);
        String rtnValue = sdf.format(date);

        return rtnValue;
    }

    public static String addDays(String dt, int days) {
        Date dt_d = DateUtil.toDate(dt);

        Calendar cal = DateUtil.getCurrentCalendar();
        cal.setTime(dt_d);

        cal.add(Calendar.DATE, days);

        return toString(cal.getTime(), TYPE_YMD);
    }

    public static Date addDays(Date dt, int days) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, days);
        return cal.getTime();
    }

    public static Date addMonths(Date dt, int months) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, months);
        return cal.getTime();
    }

    public static Date addYears(Date dt, int years) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.YEAR, years);
        return cal.getTime();
    }

    public static String toYYYYMMDD(Date dt) {
        return toString(dt, TYPE_YMD);
    }

    public static String toYYYYMMDDhhmmss(Date dt) {
        return toString(dt, TYPE_YMDHMS_NO_SPACE);
    }

    public static int getMonth(Calendar cal) {
        return cal.get(Calendar.MONTH) + 1;
    }

    public static int getYear(Calendar cal) {
        return cal.get(Calendar.YEAR);
    }

    public static int getFirstDayOfMonth(Calendar cal) {
        return cal.getActualMinimum(Calendar.DAY_OF_MONTH);
    }

    public static int getLastDayOfMonth(Calendar cal) {
        return cal.getActualMaximum(Calendar.DAY_OF_MONTH);
    }

    public static Date getCurrentDate() {
        return Calendar.getInstance().getTime();
    }

    public static Calendar getCurrentCalendar() {
        return Calendar.getInstance();
    }
}
