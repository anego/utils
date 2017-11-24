package io.github.anego.utils;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@SuppressWarnings("javadoc")
public class JsonUtilsTest extends TestCase {

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {}

    @AfterClass
    public static void tearDownAfterClass() throws Exception {}

    private JsonArray mstship;
    private JsonObject json = new JsonObject();

    @Before
    public void setUp() throws Exception {

        //
        json.addProperty("name", "anego");
        json.addProperty("age", Integer.valueOf(30));
        json.addProperty("disable", Boolean.TRUE);
        json.addProperty("regist", "2017/11/01 13:15:25");
        json.addProperty("regist_long", Long.valueOf(1509509725000L));

        JsonArray tagArray = new JsonArray();
        tagArray.add(Integer.valueOf(10));
        tagArray.add(Integer.valueOf(20));
        json.add("ary", tagArray);

        JsonObject jsonChild = new JsonObject();
        jsonChild.addProperty("skil", "{'java','go','c#'}");

        json.add("sub", jsonChild);
        json.add("null", null);

        System.out.println(JsonUtils.printClass(json));
    }

    @After
    public void tearDown() throws Exception {}

    @Test
    public void testJsonUtils() {
        try {
            Constructor<?>[] constructors = JsonUtils.class.getDeclaredConstructors();

            assertEquals(Integer.valueOf(constructors.length), Integer.valueOf(1));

            Constructor<?> defaultConstructor = constructors[0];
            assertEquals(Integer.valueOf(defaultConstructor.getParameterTypes().length),
                    Integer.valueOf(0));
            assertTrue(Modifier.isPrivate(defaultConstructor.getModifiers()));

            defaultConstructor.setAccessible(true);
            Object instance = defaultConstructor.newInstance();
            assertNotNull(instance);
            assertThat(instance, instanceOf(JsonUtils.class));
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testGetString() {

        assertThat(JsonUtils.getString(json, "name"), is("anego"));
        assertThat(JsonUtils.getString(json, "nickname"), nullValue());
        assertThat(JsonUtils.getString(json, "age"), nullValue());
        assertThat(JsonUtils.getString(json, "disable"), nullValue());
        assertThat(JsonUtils.getString(json, "null"), nullValue());

    }

    @Test
    public void testGetIntegerJsonObjectString() {

        assertThat(JsonUtils.getInteger(json, "name"), nullValue());
        assertThat(JsonUtils.getInteger(json, "nickname"), nullValue());
        assertThat(JsonUtils.getInteger(json, "age"), is(Integer.valueOf(30)));
        assertThat(JsonUtils.getInteger(json, "disable"), nullValue());
        assertThat(JsonUtils.getInteger(json, "null"), nullValue());

    }

    @Test
    public void testGetIntegerJsonElement() {

        assertThat(JsonUtils.getInteger(json.get("name")), nullValue());
        assertThat(JsonUtils.getInteger(json.get("nickname")), nullValue());
        assertThat(JsonUtils.getInteger(json.get("age")), is(Integer.valueOf(30)));
        assertThat(JsonUtils.getInteger(json.get("disable")), nullValue());

    }

    @Test
    public void testGetValue() {

        assertThat(JsonUtils.getValue(json.get("name"), v -> {
            return v;
        }), notNullValue());
        assertThat(JsonUtils.getValue(json.get("nickname"), v -> {
            return v;
        }), nullValue());
        assertThat(JsonUtils.getValue(null, v -> {
            return v;
        }), nullValue());

    }

    @Test
    public void testGetDateJsonObjectStringDateTimeFormatter() {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("uuuu/MM/dd HH:mm:ss");

        Calendar cal = Calendar.getInstance();
        cal.set(2017, 10, 1, 13, 15, 25);
        cal.set(Calendar.MILLISECOND, 0);
        Date date = cal.getTime();

        assertThat(JsonUtils.getDate(json, "regist", formatter), is(date));
        assertThat(JsonUtils.getDate(json, "regist_long", formatter), is(date));
        assertThat(JsonUtils.getDate(json, "nickname", formatter), nullValue());
        assertThat(JsonUtils.getDate(json, "sub", formatter), nullValue());

    }

    @Test
    public void testGetDateJsonElementDateTimeFormatter() {

        // TODO testGetDateJsonObjectStringDateTimeFormatter でテスト済み

    }

    @Test
    public void testGetLocalDateTimeJsonObjectStringDateTimeFormatter() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("uuuu/MM/dd HH:mm:ss");

        LocalDateTime ldt = LocalDateTime.of(2017, 11, 1, 13, 15, 25);

        assertThat(JsonUtils.getLocalDateTime(json, "regist", formatter), is(ldt));
        assertThat(JsonUtils.getLocalDateTime(json, "regist_long", formatter), is(ldt));
        assertThat(JsonUtils.getLocalDateTime(json, "nickname", formatter), nullValue());
        assertThat(JsonUtils.getLocalDateTime(json, "sub", formatter), nullValue());

    }

    @Test
    public void testGetLocalDateTimeJsonElementDateTimeFormatter() {
        // TODO testGetLocalDateTimeJsonObjectStringDateTimeFormatter でテスト済み
    }

    @Test
    public void testBind() {

        assertThat(JsonUtils.bind(json), notNullValue());

    }

    @Test
    public void testPrintClassJsonElement() {

        assertThat(JsonUtils.printClass(json), notNullValue());
        assertThat(JsonUtils.printClass(null), is("null"));


        JsonElement je = new JsonElement() {

            @Override
            public JsonElement deepCopy() {
                return null;
            }
        };
        assertThat(JsonUtils.printClass(je), notNullValue());
    }

    @Test
    public void testPrintClassJsonElementString() {
        assertThat(JsonUtils.printClass(mstship, "  "), notNullValue());
        assertThat(JsonUtils.printClass(null, "  "), is("null"));


    }


    public void testBindJsonSetIntegerString() {

        TestModel model = new TestModel();

        JsonUtils.bind(json).setInteger("age", model::setNumber);
        assertThat(model.getNumber(), notNullValue());
        assertThat(model.getNumber(), is(Integer.valueOf(30)));

        JsonUtils.bind(json).setInteger("name", model::setNumber);
        assertThat(model.getNumber(), nullValue());
    }

    public void testBindJsonSetIntegerInteger() {
        TestModel model = new TestModel();

        JsonUtils.bind(json).setInteger(Integer.valueOf(20), model::setNumber);
        assertThat(model.getNumber(), notNullValue());
        assertThat(model.getNumber(), is(Integer.valueOf(20)));

        JsonUtils.bind(json).setInteger((Integer) null, model::setNumber);
        assertThat(model.getNumber(), nullValue());
    }

    public void testBindJsonSetString() {

        TestModel model = new TestModel();

        JsonUtils.bind(json).setString("name", model::setStr);
        assertThat(model.getStr(), notNullValue());
        assertThat(model.getStr(), is("anego"));

        JsonUtils.bind(json).setString("noname", model::setStr);
        assertThat(model.getStr(), nullValue());

    }

    public void testBindJsonSetIntegerList() {

        TestModel model = new TestModel();

        JsonUtils.bind(json).setIntegerList("ary", model::setAry1, model::setAry2);
        assertThat(model.getAry1(), notNullValue());
        assertThat(model.getAry1(), is(Integer.valueOf(10)));
        assertThat(model.getAry2(), notNullValue());
        assertThat(model.getAry2(), is(Integer.valueOf(20)));

        model = new TestModel();
        JsonUtils.bind(json).setIntegerList("ary", model::setAry2);
        assertThat(model.getAry1(), nullValue());
        assertThat(model.getAry2(), notNullValue());
        assertThat(model.getAry2(), is(Integer.valueOf(10)));

        JsonUtils.bind(json).setIntegerList("aaa", model::setAry1, model::setAry2);
        assertThat(model.getAry1(), nullValue());
        assertThat(model.getAry2(), nullValue());
    }

    public void testBindJsonSetDate() {

        TestModel model = new TestModel();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("uuuu/MM/dd HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        cal.set(2017, 10, 1, 13, 15, 25);
        cal.set(Calendar.MILLISECOND, 0);
        Date date = cal.getTime();

        JsonUtils.bind(json).setDate("regist", model::setDay, formatter);
        assertThat(model.getDay(), notNullValue());
        assertThat(model.getDay(), is(date));

        JsonUtils.bind(json).setDate("aaaa", model::setDay, formatter);
        assertThat(model.getDay(), nullValue());
    }

    public void testBindJsonSetLocalDateTime() {
        TestModel model = new TestModel();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("uuuu/MM/dd HH:mm:ss");
        LocalDateTime ldt = LocalDateTime.of(2017, 11, 1, 13, 15, 25);

        JsonUtils.bind(json).setLocalDateTime("regist", model::setLocalDay, formatter);
        assertThat(model.getLocalDay(), notNullValue());
        assertThat(model.getLocalDay(), is(ldt));

        JsonUtils.bind(json).setLocalDateTime("aaaa", model::setLocalDay, formatter);
        assertThat(model.getLocalDay(), nullValue());
    }

    public void testBindJsonSetJson() {
        TestModel model = new TestModel();

        JsonUtils.bind(json).setJson("name", model::setStr);
        assertThat(model.getStr(), notNullValue());
        assertThat(model.getStr(), is("\"anego\""));

        JsonUtils.bind(json).setJson("age", model::setStr);
        assertThat(model.getStr(), notNullValue());
        assertThat(model.getStr(), is("30"));

        JsonUtils.bind(json).setJson("aaa", model::setStr);
        assertThat(model.getStr(), nullValue());
    }

}
