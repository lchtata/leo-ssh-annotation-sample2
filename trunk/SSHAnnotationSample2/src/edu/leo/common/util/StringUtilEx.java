package edu.leo.common.util;

import org.apache.commons.lang3.StringUtils;

public final class StringUtilEx {

    /**
     * Javascriptに埋め込みのために、「￥、シングルクォート,ダブルクォート」をエスケープする。
     *
     * @param src
     * @return
     */
    public static String escapeForJS(String src) {
        if (src == null) {
            return null;
        }
        String str = StringUtils.replace(src, "\\", "\\\\");
        return escapeQuote(str);
    }

    /**
     * シングルクォート,ダブルクォートをエスケープする
     *
     * @param src
     * @return　エスケープ済み文字列
     */
    public static String escapeQuote(String src) {
        if (src == null)
            return null;

        String str = StringUtils.replace(src, "'", "\\\'");
        str = StringUtils.replace(str, "\"", "\\\"");
        return str;
    }
}
