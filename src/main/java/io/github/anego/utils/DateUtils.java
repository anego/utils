package io.github.anego.utils;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * 日付関連の共通処理.
 *
 * @author anego &#60;anego@project-life.net&#62;
 *
 */
public final class DateUtils {

    /**
     * 文字列を指定フォーマッタでパースして日付型を返す.<br>
     * 変換できない場合はNULLを返す.
     *
     * @param string 変換文字列
     * @param dtfJsonfilename 日付フォーマッタ
     * @return 日付
     */
    public static Date parse(String string, DateTimeFormatter dtfJsonfilename) {
        Date createdatetime = null;
        try {
            LocalDateTime localdate = LocalDateTime.parse(string, dtfJsonfilename);
            createdatetime = Date.from(localdate.atZone(ZoneId.systemDefault()).toInstant());
        } catch (Exception exc) {
            throw exc;
        }
        return createdatetime;
    }

    /**
     * 文字列を指定フォーマッタでパースして日付型を返す.<br>
     * 変換できない場合はNULLを返す.
     *
     * @param string 変換文字列
     * @param dtfJsonfilename 日付フォーマッタ
     * @return 日付
     */
    public static LocalDateTime parseLocalDateTime(String string,
            DateTimeFormatter dtfJsonfilename) {
        LocalDateTime localdate = null;
        try {
            localdate = LocalDateTime.parse(string, dtfJsonfilename);
        } catch (Exception exc) {
            throw exc;
        }
        return localdate;
    }

    /**
     * 新日時APIを旧日時APIに変換する
     *
     * @param ldt 変換する日時
     * @return 変換後日時
     * @see "http://tamata78.hatenablog.com/entry/2017/06/21/081512"
     */
    public static Date localDateTime2Date(LocalDateTime ldt) {
        return Date.from(ldt.toInstant(ZoneId.systemDefault().getRules().getOffset(ldt)));
    }

    /**
     * 旧日時APIを新日時APIに変換する
     *
     * @param date 変換する日時
     * @return 変換後日時
     * @see "http://tamata78.hatenablog.com/entry/2017/06/21/081512"
     */
    public static LocalDateTime date2LocalDateTime(Date date) {
        return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
    }

}
