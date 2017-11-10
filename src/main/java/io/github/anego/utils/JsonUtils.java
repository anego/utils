package io.github.anego.utils;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Map;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import lombok.AllArgsConstructor;

/**
 * JSON関連の共通処理.
 *
 * @author anego &#60;anego@project-life.net&#62;
 *
 */
public final class JsonUtils {

    private JsonUtils() {}

    /**
     * keyでマップされた値をStringとして取り出す。<br>
     * jsonString以外の場合は変換をしてみてだめならnullを返す。.
     *
     * @param json JsonObject
     * @param key キー
     * @return 取り出した値
     */
    public static String getString(JsonObject json, String key) {

        JsonElement value = json.get(key);
        return getValue(value, v -> {
            if (v != null && v.isJsonPrimitive() && v.getAsJsonPrimitive().isString()) {
                return v.getAsString();
            }
            return null;
        });
    }

    /**
     * keyでマップされた値をIntegerとして取り出す。<br>
     * jsonNumber以外の場合はnullを返す。.
     *
     * @param json JsonObject
     * @param key キー
     * @return 取り出した値
     */
    public static Integer getInteger(JsonObject json, String key) {

        JsonElement value = json.get(key);

        return JsonUtils.getInteger(value);
    }

    /**
     * valからInteger型の値を取得する。<br>
     * JsonNumber以外ならnullを返す。.
     *
     * @param val Json
     * @return 取り出した値
     */
    public static Integer getInteger(JsonElement val) {
        return Optional.ofNullable(val).map(v -> {
            if (!v.isJsonNull() && v.isJsonPrimitive() && v.getAsJsonPrimitive().isNumber()) {
                return Integer.valueOf(v.getAsInt());
            }
            return null;
        }).orElse(null);
    }

    /**
     * JsonValueからfuncの変換関数を使用して値を取り出す.
     *
     * @param val JsonObject
     * @param func 変換関数
     * @return 取り出した値
     */
    public static <T extends JsonElement, R> R getValue(T val, Function<T, R> func) {
        if (val == null || val.isJsonNull()) {
            return null;
        }

        return func.apply(val);
    }

    /**
     * keyでマップされた値をDateとして取り出す。<br>
     * LongかStringが対象。<br>
     * それ以外ならnullを返す。.
     *
     * @param json JsonObject
     * @param key キー
     * @param formatter 文字列の場合に使用するフォーマッタ
     * @return 取り出した日時
     */
    public static Date getDate(JsonObject json, String key, DateTimeFormatter formatter) {

        JsonElement value = json.get(key);

        return JsonUtils.getDate(value, formatter);
    }

    /**
     * valからDate型の値を取得する。<br>
     * LongかStringが対象。<br>
     * それ以外ならnullを返す。.
     *
     * @param val Json
     * @param formatter 文字列の場合に使用するフォーマッタ
     * @return 取り出した日時
     */
    public static Date getDate(JsonElement val, DateTimeFormatter formatter) {
        if (val == null || val.isJsonNull()) {
            return null;
        } else if (val.isJsonPrimitive()) {
            if (val.getAsJsonPrimitive().isNumber()) {
                return new Date(val.getAsLong());
            } else if (val.getAsJsonPrimitive().isString()) {
                LocalDateTime localdate = LocalDateTime.parse(val.getAsString(), formatter);
                return Date.from(localdate.atZone(ZoneId.systemDefault()).toInstant());
            }
        }

        return null;
    }

    /**
     * keyでマップされた値をLocalDateTimeとして取り出す。<br>
     * LongかStringが対象。<br>
     * それ以外ならnullを返す。.
     *
     * @param json JsonObject
     * @param formatter 文字列の場合に使用するフォーマッタ
     * @param key キー
     * @return 取り出した日時
     */
    public static LocalDateTime getLocalDateTime(JsonObject json, String key,
            DateTimeFormatter formatter) {

        JsonElement value = json.get(key);

        return JsonUtils.getLocalDateTime(value, formatter);
    }

    /**
     * valからLocalDateTime型の値を取得する。<br>
     * LongかStringが対象。<br>
     * それ以外ならnullを返す。.
     *
     * @param val Json
     * @param formatter 文字列の場合に使用するフォーマッタ
     * @return 取り出した値
     */
    public static LocalDateTime getLocalDateTime(JsonElement val, DateTimeFormatter formatter) {
        if (val == null || val.isJsonNull()) {
            return null;
        } else if (val.isJsonPrimitive()) {
            if (val.getAsJsonPrimitive().isNumber()) {
                return LocalDateTime.ofInstant(Instant.ofEpochMilli(val.getAsLong()),
                        ZoneId.systemDefault());
            } else if (val.getAsJsonPrimitive().isString()) {
                LocalDateTime localdate = LocalDateTime.parse(val.getAsString(), formatter);
                return localdate;
            }
        }

        return null;
    }

    /**
     * JsonObjectのバインド.
     *
     * @param json JsonObject
     * @return ユーティリティにバインドされたクラス
     */
    public static BindJson bind(JsonObject json) {
        return new BindJson(json);
    }

    /**
     * @author anego &#60;anego@project-life.net&#62;
     *
     */
    @AllArgsConstructor
    public static class BindJson {

        /** バインドされたJsonObject. */
        private JsonObject json;

        /**
         * JsonObjectからkeyでJsonValueを探し、consで指定されたsetterに渡す.
         *
         * @param value JsonObjectで探すキー
         * @param cons キーを元に探したJsonValueの値を渡すsetter
         * @return {@link BindJson}
         */
        public final BindJson setInteger(Integer value, Consumer<Integer> cons) {
            cons.accept(value);
            return this;
        }

        /**
         * JsonObjectからkeyでJsonValueを探し、consで指定されたsetterに渡す.
         *
         * @param key JsonObjectで探すキー
         * @param cons キーを元に探したJsonValueの値を渡すsetter
         * @return {@link BindJson}
         */
        public final BindJson setInteger(String key, Consumer<Integer> cons) {
            cons.accept(JsonUtils.getInteger(this.json, key));
            return this;
        }

        /**
         * JsonObjectからkeyでJsonValueを探し、consで指定されたsetterに渡す.
         *
         * @param key JsonObjectで探すキー
         * @param cons キーを元に探したJsonValueの値を渡すsetter
         * @return {@link BindJson}
         **/
        public final BindJson setString(String key, Consumer<String> cons) {
            cons.accept(JsonUtils.getString(this.json, key));
            return this;
        }


        /**
         * JsonObjectから配列の値をIntegerで取り出し、consで指定されたsteerに渡す。.
         *
         * @param key キー
         * @param cons キーを元に探したJsonValueの値を渡すsetter
         * @return {@link BindJson}
         */
        @SafeVarargs
        public final BindJson setIntegerList(String key, Consumer<Integer>... cons) {
            JsonElement val = this.json.get(key);
            if (val == null) {
                for (int index = 0; index < cons.length; index++) {
                    cons[index].accept(null);
                }
                return this;
            } else if (val.isJsonArray()) {
                JsonArray ja = ((JsonArray) val);

                for (int index = 0; index < ja.size() && index < cons.length; index++) {
                    cons[index].accept(JsonUtils.getInteger(ja.get(index)));
                }

            }
            // else {
            // log.error("JsonType:" + printClass(val));
            // }

            return this;
        }


        /**
         * JsonObjectからkeyの値を日時に変換して取り出す.
         *
         * @param key キー
         * @param cons 変換した値を渡すsetter
         * @param formatter 文字列の場合に使用するフォーマッタ
         * @return 取り出した日時
         */
        public final BindJson setDate(String key, Consumer<Date> cons,
                DateTimeFormatter formatter) {
            cons.accept(JsonUtils.getDate(this.json, key, formatter));
            return this;
        }

        /**
         * JsonObjectからkeyの値を日時に変換して取り出す.
         *
         * @param key キー
         * @param cons 変換した値を渡すsetter
         * @param formatter 文字列の場合に使用するフォーマッタ
         * @return 取り出した日時
         */
        public final BindJson setLocalDateTime(String key, Consumer<LocalDateTime> cons,
                DateTimeFormatter formatter) {
            cons.accept(JsonUtils.getLocalDateTime(this.json, key, formatter));
            return this;
        }

        /**
         * JsonObjectからキーのJsonObjectを取り出し、consで指定されたsteerにJSON形式の文字列で渡す。.
         *
         * @param key キー
         * @param cons キーを元に探したJsonObjectのJSON文字列を渡すsetter
         * @return {@link BindJson}
         */
        public BindJson setJson(String key, Consumer<String> cons) {
            JsonElement val = this.json.get(key);
            if (val != null) {
                cons.accept(val.toString());
            }

            return this;
        }
    }

    /**
     * Jsonデータの型と内容をデバッグ用に文字列変換する.
     *
     * @param je 対象データ
     * @return 対象の文字列
     */
    public static String printClass(JsonElement je) {
        return printClass(je, "    ");
    }

    /**
     * JsonElement内のデータタイプを取得する.
     *
     * @param je 対象データ
     * @param ident コレクションを出力するときのインデント
     * @return データタイプ
     * @see "https://stackoverflow.com/questions/20624042/how-to-get-json-element-type-with-gson"
     */
    public static String printClass(JsonElement je, String ident) {

        StringBuilder sb = null;
        if (je == null || je.isJsonNull()) {
            return "null";
        }

        if (je.isJsonPrimitive()) {
            if (je.getAsJsonPrimitive().isBoolean()) {
                return "Boolean";
            } else if (je.getAsJsonPrimitive().isString()) {
                return "String";
            } else if (je.getAsJsonPrimitive().isNumber()) {
                return "Number";
            }
        }

        if (je.isJsonArray()) {
            sb = new StringBuilder("array<");
            for (JsonElement e : je.getAsJsonArray()) {
                sb.append(printClass(e, ident + "    "));
            }
            sb.append(">");
            return sb.toString();
        }

        if (je.isJsonObject()) {
            sb = new StringBuilder("map<\n");
            for (Map.Entry<String, JsonElement> e : je.getAsJsonObject().entrySet()) {
                sb.append(ident);
                sb.append(e.getKey()).append(":");
                sb.append(printClass(e.getValue(), ident + "   "));
                sb.append("\n");
            }
            sb.append(ident);
            sb.append(">");
            return sb.toString();
        }
        return "";

    }
}
