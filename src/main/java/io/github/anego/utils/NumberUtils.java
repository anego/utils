package io.github.anego.utils;

import java.math.BigDecimal;
import java.text.Normalizer;
import java.util.Optional;
import org.apache.commons.lang3.StringUtils;

/**
 * 数値系オブジェクトのユーティリティ.
 *
 * @author anego &#60;anego@project-life.net&#62;
 *
 */
public final class NumberUtils {

    /**
     * <p>
     * NULLか-1以下ならTrue.
     * </p>
     *
     * <pre>
     * null    = true
     * -1      = true
     * 0       = false
     * 1       = false
     * </pre>
     *
     * @param val 対象数値
     * @return true:NULLか-1以下<br>
     *         false:1以上
     */
    public static boolean isEmpty(final Short val) {
        if (val == null || val.intValue() < 0) {
            return true;
        }

        return false;
    }

    /**
     * <p>
     * NULLか0以下ならTrue.
     * </p>
     *
     * <pre>
     * null    = true
     * -1      = true
     * 0       = false
     * 1       = false
     * </pre>
     *
     * @param val 対象数値
     * @return true:NULLか0以下<br>
     *         false:1以上
     */
    public static boolean isEmpty(final Integer val) {
        if (val == null || val.intValue() < 0) {
            return true;
        }

        return false;
    }

    /**
     * <p>
     * NULLか-1以下ならTrue.
     * </p>
     *
     * <pre>
     * null    = true
     * -1      = true
     * 0       = false
     * 1       = false
     * </pre>
     *
     * @param val 対象数値
     * @return true:NULLか-1以下<br>
     *         false:1以上
     */
    public static boolean isEmpty(final Long val) {
        if (val == null || val.longValue() < 0) {
            return true;
        }

        return false;
    }

    /**
     * <p>
     * NULLか-1以下ならfalse.
     * </p>
     *
     * <pre>
     * null    = false
     * -1      = false
     * 0       = true
     * 1       = true
     * </pre>
     *
     * @param val 対象数値
     * @return false:NULLか-1以下<br>
     *         true:1以上
     */
    public static boolean isNotEmpty(final Short val) {
        return !isEmpty(val);
    }

    /**
     * <p>
     * NULLか-1以下ならfalsee.
     * </p>
     *
     * <pre>
     * null    = false
     * -1      = false
     * 0       = true
     * 1       = true
     * </pre>
     *
     * @param val 対象数値
     * @return true:NULLか0以下<br>
     *         false:1以上
     */
    public static boolean isNotEmpty(final Integer val) {

        return !isEmpty(val);
    }

    /**
     * <p>
     * NULLか-1以下ならfalse.
     * </p>
     *
     * <pre>
     * null    = false
     * -1      = false
     * 0       = true
     * 1       = true
     * </pre>
     *
     * @param val 対象数値
     * @return false:NULLか-1以下<br>
     *         true:1以上
     */
    public static boolean isNotEmpty(final Long val) {
        return !isEmpty(val);
    }

    /**
     * <p>
     * NULLもしくは0以下ならTrue.
     * </p>
     *
     * <pre>
     * null    = true
     * -1      = true
     * 0       = true
     * 1       = false
     * </pre>
     *
     * @param val 対象数値
     * @return true:NULLか0以下<br>
     *         false:1以上
     */
    public static boolean isBlank(final Long val) {
        if (val == null) {
            return true;
        }

        if (val.longValue() <= 0) {
            return true;
        }

        return false;
    }

    /**
     * <p>
     * NULLもしくは0以下ならTrue.
     * </p>
     *
     * <pre>
     * null    = true
     * -1      = true
     * 0       = true
     * 1       = false
     * </pre>
     *
     * @param val 対象数値
     * @return true:NULL、0以下ではない<br>
     *         false:1以上
     */
    public static boolean isBlank(final Integer val) {
        if (val == null) {
            return true;
        }

        if (val.intValue() <= 0) {
            return true;
        }

        return false;
    }

    /**
     * <p>
     * NULLもしくは0以下ならTrue.
     * </p>
     *
     * <pre>
     * null    = true
     * -1      = true
     * 0       = true
     * 1       = false
     * </pre>
     *
     * @param val 対象数値
     * @return true:NULL、0以下ではない<br>
     *         false:1以上
     */
    public static boolean isBlank(final Short val) {
        if (val == null) {
            return true;
        }

        if (val.intValue() <= 0) {
            return true;
        }

        return false;
    }

    /**
     * <p>
     * NULLもしくは0以下ならFalse.
     * </p>
     *
     * <pre>
     * null    = false
     * -1      = false
     * 0       = false
     * 1       = true
     * </pre>
     *
     * @param val 対象数値
     * @return false:NULL、0以下ではない<br>
     *         true:1以上
     */
    public static boolean isNotBlank(final Long val) {
        return !NumberUtils.isBlank(val);
    }

    /**
     * <p>
     * NULLもしくは0以下ならFalse.
     * </p>
     *
     * <pre>
     * null    = false
     * -1      = false
     * 0       = false
     * 1       = true
     * </pre>
     *
     * @param val 対象数値
     * @return false:NULL、0以下ではない<br>
     *         true:1以上
     */
    public static boolean isNotBlank(final Integer val) {
        if (val == null) {
            return false;
        }

        if (val.intValue() <= 0) {
            return false;
        }

        return true;
    }

    /**
     * <p>
     * NULLもしくは0以下ならFalse.
     * </p>
     *
     * <pre>
     * null    = false
     * -1      = false
     * 0       = false
     * 1       = true
     * </pre>
     *
     * @param val 対象数値
     * @return false:NULL、0以下ではない<br>
     *         true:1以上
     */
    public static boolean isNotBlank(final Short val) {
        if (val == null) {
            return false;
        }

        if (val.intValue() <= 0) {
            return false;
        }

        return true;
    }

    /**
     * 文字列を数値に変換.<br>
     * 10進数のみ.<br>
     * 変換できなければ0.
     *
     * @param val 変換する文字列
     * @return 変換後数値
     */
    public static int toInt(final String val) {

        if (val == null) {
            return 0;
        }

        String str = Normalizer.normalize(val, Normalizer.Form.NFKC);

        if (!org.apache.commons.lang3.math.NumberUtils.isCreatable(str)) {
            return 0;
        }

        BigDecimal decimal = new BigDecimal(val);
        double dbl = decimal.doubleValue();
        if (dbl > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else if (dbl < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }

        return decimal.intValue();
    }

    /**
     * ShortをNULLチェックしてintに変換.
     *
     * @param val 変換する数値
     * @return 変換後
     */
    public static int toInt(final Short val) {
        if (val == null) {
            return 0;
        }
        return val.intValue();
    }

    /**
     * ShortをNULLチェックしてintに変換.
     *
     * @param val 変換する数値
     * @param defaultValue NULLの場合のデフォルト値
     * @return 変換後
     */
    public static int toInt(final Short val, final int defaultValue) {
        if (val == null) {
            return defaultValue;
        }
        return val.intValue();
    }

    /**
     * IntegerをNULLチェックしてintに変換.
     *
     * @param val 変換する数値
     * @return 変換後
     */
    public static int toInt(final Integer val) {
        return NumberUtils.toInt(val, 0);
    }

    /**
     * IntegerをNULLチェックしてintに変換.
     *
     * @param val 変換する数値
     * @param defaultValue NULLの場合のデフォルト値
     * @return 変換後
     */
    public static int toInt(final Integer val, int defaultValue) {
        if (val == null) {
            return defaultValue;
        }

        return val.intValue();
    }

    /**
     * LongをNULLチェックしてintにするだけ.
     *
     * @param val 変換する数値
     * @return 変換後
     */
    public static int toInt(final Long val) {
        return NumberUtils.toInt(val, 0);
    }

    /**
     * LongをNULLチェックしてintにするだけ.
     *
     * @param val 変換する数値
     * @param defaultValue NULLの場合のデフォルト値
     * @return 変換後
     */
    public static int toInt(final Long val, int defaultValue) {
        if (val == null) {
            return defaultValue;
        }

        return val.intValue();
    }

    /**
     * BooleanをNULLチェックしてintにするだけ.
     *
     * @param val 変換する値
     * @return 変換後
     */
    public static int toInt(final Boolean val) {
        if (val == null) {
            return 0;
        }

        if (val.booleanValue()) {
            return 1;
        }
        return 0;
    }

    /**
     * ByteをNULLチェックしてShortにするだけ.
     *
     * @param val 変換する値
     * @return 変換後の値
     */
    public static Short toShort(final Byte val) {

        if (val == null) {
            return null;
        }

        return Short.valueOf(val.shortValue());
    }

    /**
     * int をShortに変換.
     *
     * @param val 対象数値
     * @return 変換後数値
     */
    public static Short toShort(int val) {

        if (val > Short.MAX_VALUE) {
            return Short.valueOf(Short.MAX_VALUE);
        } else if (val < Short.MIN_VALUE) {
            return Short.valueOf(Short.MIN_VALUE);
        }

        return Short.valueOf((short) val);
    }

    /**
     * Short をShortに変換.
     *
     * @param val 対象数値
     * @param defaultval NULLの場合のデフォルト値
     * @return 変換後数値
     */
    public static Short toShort(Short val, int defaultval) {

        if (val == null) {
            return Short.valueOf((short) defaultval);
        }

        return val;
    }

    /**
     * Integer をShortに変換.
     *
     * @param val 対象数値
     * @return 変換後数値
     */
    public static Short toShort(Integer val) {

        return NumberUtils.toShort(val, (short) 0);
    }

    /**
     * Integer をShortに変換.
     *
     * @param val 対象数値
     * @param defaultval NULLの場合のデフォルト値
     * @return 変換後数値
     */
    public static Short toShort(Integer val, short defaultval) {

        if (val == null) {
            return Short.valueOf(defaultval);
        } else if (val.intValue() > Short.MAX_VALUE) {
            return Short.valueOf(Short.MAX_VALUE);
        } else if (val.intValue() < Short.MIN_VALUE) {
            return Short.valueOf(Short.MIN_VALUE);
        }

        return Short.valueOf(val.shortValue());
    }

    /**
     * long をShortに変換.
     *
     * @param val 対象数値
     * @return 変換後数値
     */
    public static Short toShort(long val) {

        if (val > Short.MAX_VALUE) {
            return Short.valueOf(Short.MAX_VALUE);
        } else if (val < Short.MIN_VALUE) {
            return Short.valueOf(Short.MIN_VALUE);
        }

        return Short.valueOf(Long.valueOf(val).shortValue());
    }

    /**
     * LongをNULLチェックしてShortに変換.
     *
     * @param val 対象数値
     * @return 変換後数値
     */
    public static Short toShort(Long val) {
        if (val == null) {
            return null;
        } else if (val.longValue() > Short.MAX_VALUE) {
            return Short.valueOf(Short.MAX_VALUE);
        } else if (val.longValue() < Short.MIN_VALUE) {
            return Short.valueOf(Short.MIN_VALUE);
        }

        return Short.valueOf(val.shortValue());
    }

    /**
     * 文字列をNUULLチェックしてShortに変換.
     *
     * @param val 対象文字列
     * @return 変換後の値
     */
    public static Short toShort(final String val) {

        if (StringUtils.isBlank(val)) {
            return null;
        }

        String str = Normalizer.normalize(val, Normalizer.Form.NFKC);

        if (!org.apache.commons.lang3.math.NumberUtils.isCreatable(str)) {
            return null;
        }

        BigDecimal decimal = new BigDecimal(val);
        double dbl = decimal.doubleValue();
        if (dbl > Short.MAX_VALUE) {
            return Short.valueOf(Short.MAX_VALUE);
        } else if (dbl < Short.MIN_VALUE) {
            return Short.valueOf(Short.MIN_VALUE);
        }

        return Short.valueOf(decimal.shortValue());
    }

    /**
     * 文字列をチェックしてShortに変換.
     *
     * @param val 対象文字列
     * @param defaultValue NULL、または変換できなかった場合のデフォルト値
     * @return 変換後の値
     */
    public static Short toShort(final String val, final int defaultValue) {

        if (StringUtils.isBlank(val)) {
            return Short.valueOf((short) defaultValue);
        }

        String str = Normalizer.normalize(val, Normalizer.Form.NFKC);

        if (!org.apache.commons.lang3.math.NumberUtils.isCreatable(str)) {
            return Short.valueOf((short) defaultValue);
        }

        BigDecimal decimal = new BigDecimal(val);
        double dbl = decimal.doubleValue();
        if (dbl > Short.MAX_VALUE) {
            return Short.valueOf(Short.MAX_VALUE);
        } else if (dbl < Short.MIN_VALUE) {
            return Short.valueOf(Short.MIN_VALUE);
        }

        return Short.valueOf(decimal.shortValue());
    }

    /**
     * ShortをNULLチェックしてIntegerにするだけ.<br>
     * NULLの場合はdefaulValueでIntegerを作って返す.
     *
     * @param val 変換する数値
     * @param defaultValue NULLの場合のデフォルト値
     * @return 変換後
     */
    public static Integer toInteger(final Short val, int defaultValue) {

        if (val == null) {
            return Integer.valueOf(defaultValue);
        }

        return Integer.valueOf(val.intValue());
    }

    /**
     * IntegerをNULLチェックしてIntegerにするだけ.<br>
     * NULLの場合はdefaulValueでIntegerを作って返す.
     *
     * @param val 変換する数値
     * @param defaultValue NULLの場合のデフォルト値
     * @return 変換後
     */
    public static Integer toInteger(final Integer val, int defaultValue) {

        if (val == null) {
            return Integer.valueOf(defaultValue);
        }

        return val;
    }

    /**
     * longをIntegerにするだけ.
     *
     * @param val 変換する数値
     * @return 変換後
     */
    public static Integer toInteger(final long val) {

        if (val > Integer.MAX_VALUE) {
            return Integer.valueOf(Integer.MAX_VALUE);
        } else if (val < Integer.MIN_VALUE) {
            return Integer.valueOf(Integer.MIN_VALUE);
        }

        return Integer.valueOf(Long.valueOf(val).intValue());
    }

    /**
     * LongをNULLチェックしてIntegerにするだけ.
     *
     * @param val 変換する数値
     * @return 変換後
     */
    public static Integer toInteger(final Long val) {

        if (val == null) {
            return null;
        }

        if (val.longValue() > Integer.MAX_VALUE) {
            return Integer.valueOf(Integer.MAX_VALUE);
        } else if (val.longValue() < Integer.MIN_VALUE) {
            return Integer.valueOf(Integer.MIN_VALUE);
        }

        return Integer.valueOf(val.intValue());
    }

    /**
     * StringをNULLチェックしてIntegerにするだけ.
     *
     * @param val 変換する数値
     * @return 変換後
     */
    public static Integer toInteger(final String val) {

        if (StringUtils.isBlank(val)) {
            return null;
        }

        String str = Normalizer.normalize(val, Normalizer.Form.NFKC);

        if (!org.apache.commons.lang3.math.NumberUtils.isCreatable(str)) {
            return Integer.valueOf(0);
        }

        BigDecimal decimal = new BigDecimal(val);
        double dbl = decimal.doubleValue();
        if (dbl > Integer.MAX_VALUE) {
            return Integer.valueOf(Integer.MAX_VALUE);
        } else if (dbl < Integer.MIN_VALUE) {
            return Integer.valueOf(Integer.MIN_VALUE);
        }

        return Integer.valueOf(decimal.intValue());
    }

    /**
     * ByteをNULLチェックしてIntegerにするだけ.
     *
     * @param val 変換する数値
     * @return 変換後
     */
    public static Integer toInteger(final Byte val) {
        return Optional.ofNullable(val).map(mapper -> Integer.valueOf(mapper.intValue()))
                .orElse(null);
    }

    /**
     * ShortをNULLチェックしてIntegerにするだけ.
     *
     * @param val 変換する数値
     * @return 変換後
     */
    public static Integer toInteger(final Short val) {
        return Optional.ofNullable(val).map(mapper -> Integer.valueOf(mapper.intValue()))
                .orElse(null);
    }

    /**
     * BigDecimalをIntegerに変換. <br>
     * 小数部は切り捨てられ、intに収まらない場合も切り捨てられる
     *
     * @param val 変換する数値
     * @return 変換後
     */
    public static Integer toInteger(final BigDecimal val) {
        return Optional.ofNullable(val).map(mapper -> {
            if (mapper.longValue() > Integer.MAX_VALUE) {
                return Integer.valueOf(Integer.MAX_VALUE);
            } else if (mapper.longValue() < Integer.MIN_VALUE) {
                return Integer.valueOf(Integer.MIN_VALUE);
            }
            return Integer.valueOf(val.intValue());
        }).orElse(null);
    }

    /**
     * IntegerをNULLチェックしてLongにするたけ.
     *
     * @param val 変換する数値
     * @return 変換後
     */
    public static Long toLong(final Integer val) {

        if (val == null) {
            return null;
        }

        return new Long(val.longValue());
    }

    /**
     * StringをLongに変換するだけ.
     *
     * @param val 対象文字列
     * @return 変換後
     */
    public static Long toLong(final String val) {

        if (StringUtils.isBlank(val)) {
            return null;
        }

        String str = Normalizer.normalize(val, Normalizer.Form.NFKC);

        if (!org.apache.commons.lang3.math.NumberUtils.isCreatable(str)) {
            return null;
        }

        BigDecimal decimal = new BigDecimal(val);
        double dbl = decimal.doubleValue();
        if (dbl > Long.MAX_VALUE) {
            return Long.valueOf(Long.MAX_VALUE);
        } else if (dbl < Long.MIN_VALUE) {
            return Long.valueOf(Long.MIN_VALUE);
        }

        return Long.valueOf(decimal.longValue());
    }

    /**
     * ShortをNULLチェックしてByteに変換するだけ.
     *
     * @param val 対象の値
     * @return Byteに変換したval
     */
    public static Byte toByte(final Short val) {
        if (val == null) {
            return null;
        } else if (val.shortValue() > Byte.MAX_VALUE) {
            return Byte.valueOf(Byte.MAX_VALUE);
        } else if (val.shortValue() < Byte.MIN_VALUE) {
            return Byte.valueOf(Byte.MIN_VALUE);
        }

        return Byte.valueOf(val.byteValue());
    }

    /**
     * 文字列をNULLチェックしてfloatに変換するだけ.
     *
     * @param val 対象文字列
     * @return 変換後
     */
    public static float toFloat(final String val) {

        if (StringUtils.isBlank(val)) {
            return 0;
        }

        String str = Normalizer.normalize(val, Normalizer.Form.NFKC);

        if (!org.apache.commons.lang3.math.NumberUtils.isCreatable(str)) {
            return 0;
        }

        BigDecimal decimal = new BigDecimal(val);
        double dbl = decimal.doubleValue();
        if (dbl > Float.MAX_VALUE) {
            return Float.MAX_VALUE;
        } else if (dbl < Float.MIN_VALUE) {
            return Float.MIN_VALUE;
        }

        return decimal.floatValue();
    }

    /**
     * NULLチェックしてdoubleを返すだけ.
     *
     * @param val 対象値
     * @return チェック後値
     */
    public static double toDouble(final Double val) {
        if (val == null) {
            return 0d;
        }

        return val.doubleValue();
    }

    /**
     * 文字列をIntegerに変換できるかどうかの判定.
     *
     * @param val チェック対象文字列
     * @return チェック結果
     */
    public static boolean isInteger(final String val) {

        try {
            Integer.parseInt(val);
        } catch (@SuppressWarnings("unused") NumberFormatException exc) {
            return false;
        }

        return true;
    }

    /**
     * 文字列をLongに変換できるかどうかの判定.
     *
     * @param val チェック対象文字列
     * @return チェック結果
     */
    public static boolean isLong(final String val) {

        try {
            Long.parseLong(val);
        } catch (@SuppressWarnings("unused") NumberFormatException exc) {
            return false;
        }

        return true;
    }

    /**
     * doubleの少数<i>degit</i>桁で四捨五入する.<br>
     * java8ではdoubleの四捨五入に誤差が出るので念のための対応
     *
     * @param val 対象値
     * @param degit 四捨五入する桁
     * @return 変換後値
     */
    public static double decimalScale(double val, int degit) {

        BigDecimal bd = BigDecimal.valueOf(val);

        return bd.setScale(degit, BigDecimal.ROUND_HALF_UP).doubleValue();
    }
}
