package io.github.anego.utils;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

@SuppressWarnings("javadoc")
public class JsonUtilsTest {

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {}

    @AfterClass
    public static void tearDownAfterClass() throws Exception {}

    JsonObject jsonRoot;

    @Before
    public void setUp() throws Exception {

        Path path = Paths.get(ClassLoader.getSystemResource("test.json").toURI());
        Reader reader = Files.newBufferedReader(path);
        JsonObject json = new Gson().fromJson(reader, JsonObject.class);
        JsonElement jsonvalue = json.get("api_data");
        assertThat(jsonvalue, notNullValue());
        assertThat(Boolean.valueOf(jsonvalue.isJsonObject()), is(Boolean.TRUE));

        jsonRoot = jsonvalue.getAsJsonObject();
        // JsonObject root = jsonvalue.getAsJsonObject();
        // if (!root.get("api_mst_stype").isJsonNull()) {
        // // this.shiptype = root.get("api_mst_stype").getAsJsonArray();
        // // assertNotNull(this.shiptype);
        // // assertFalse(this.shiptype.isJsonNull());
        // }

    }

    @After
    public void tearDown() throws Exception {}

    // @Test
    // public void testGetString() {
    // fail("まだ実装されていません");
    // }
    //
    // @Test
    // public void testGetIntegerJsonObjectString() {
    // fail("まだ実装されていません");
    // }
    //
    // @Test
    // public void testGetIntegerJsonElement() {
    // fail("まだ実装されていません");
    // }
    //
    // @Test
    // public void testGetValue() {
    // fail("まだ実装されていません");
    // }
    //
    // @Test
    // public void testGetDateJsonObjectStringDateTimeFormatter() {
    // fail("まだ実装されていません");
    // }
    //
    // @Test
    // public void testGetDateJsonElementDateTimeFormatter() {
    // fail("まだ実装されていません");
    // }
    //
    // @Test
    // public void testGetLocalDateTimeJsonObjectStringDateTimeFormatter() {
    // fail("まだ実装されていません");
    // }
    //
    // @Test
    // public void testGetLocalDateTimeJsonElementDateTimeFormatter() {
    // fail("まだ実装されていません");
    // }
    //
    // @Test
    // public void testBind() {
    // fail("まだ実装されていません");
    // }
    //
    // @Test
    // public void testPrintClassJsonElement() {
    // fail("まだ実装されていません");
    // }
    //
    // @Test
    // public void testPrintClassJsonElementString() {
    // fail("まだ実装されていません");
    // }

}
