package edu.leo.common.util;

import org.apache.log4j.FileAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.RollingFileAppender;

/**
 * Log4jのユティリテイクラス
 */
public final class LoggerUtil {

    /**
     * ロゴの名前を指定し、Appenderを作成してLoggerを戻す
     *
     * @param name
     *            ログのファイル前
     * @return Logger
     */
    public static Logger getLoggerByName(String name) {
        // loggerを取得
        Logger logger = Logger.getLogger(name);
        // loggerの下の全部Appenderを消す
        logger.removeAllAppenders();
        // logのラベルを設定(debug)
        logger.setLevel(Level.DEBUG);
        // rootを承継するかどうか
        logger.setAdditivity(true);
        // log出力する形式
        FileAppender appender = new RollingFileAppender();
        PatternLayout layout = new PatternLayout();
        layout.setConversionPattern("[%d] %p %t %c - %m%n");
        appender.setLayout(layout);
        // log出力パス
        String tomcatPath = java.lang.System.getProperty("catalina.home");
        appender.setFile(tomcatPath + "/logs/" + name + ".log");
        // logのエンコーディング
        appender.setEncoding("UTF-8");
        // ファイルの中身を追加/ファイルを上書き
        appender.setAppend(true);
        // 変更を有効化
        appender.activateOptions();
        // loggerに追加
        logger.addAppender(appender);
        return logger;
    }
}
