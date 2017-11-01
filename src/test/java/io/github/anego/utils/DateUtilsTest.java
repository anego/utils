package io.github.anego.utils;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import org.junit.Test;

@SuppressWarnings("javadoc")
public class DateUtilsTest {

    @Test
    public void testDateUtils() {
        try {
            Constructor<?>[] constructors = DateUtils.class.getDeclaredConstructors();

            assertEquals(Integer.valueOf(constructors.length), Integer.valueOf(1));

            Constructor<?> defaultConstructor = constructors[0];
            assertEquals(Integer.valueOf(defaultConstructor.getParameterTypes().length),
                    Integer.valueOf(0));
            assertTrue(Modifier.isPrivate(defaultConstructor.getModifiers()));

            defaultConstructor.setAccessible(true);
            Object instance = defaultConstructor.newInstance();
            assertNotNull(instance);
            assertThat(instance, instanceOf(DateUtils.class));
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testParse() {

        LocalDateTime ldt = LocalDateTime.of(2017, 10, 29, 10, 15, 30);
        Date dateTarget = Date.from(ldt.atZone(ZoneId.systemDefault()).toInstant());

        assertThat(DateUtils.parse("2017-10-29T10:15:30", null), is(dateTarget));

        try {
            DateUtils.parse("2017-10-29T30:15:30", null);
            fail("例外パターン");
        } catch (Exception e) {
            assertThat(e, is(notNullValue()));
        }

        assertThat(DateUtils.parse("2017-10-29 10:15:30",
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")), is(dateTarget));

    }

    @Test
    public void testParseLocalDateTime() {

        LocalDateTime ldt = LocalDateTime.of(2017, 10, 29, 10, 15, 30);

        assertThat(DateUtils.parseLocalDateTime("2017-10-29T10:15:30", null), is(ldt));
        try {
            DateUtils.parseLocalDateTime("2017-10-29T30:15:30", null);
            fail("例外パターン");
        } catch (Exception e) {
            assertThat(e, is(notNullValue()));
        }

        assertThat(DateUtils.parseLocalDateTime("2017-10-29 10:15:30",
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")), is(ldt));
    }

    @Test
    public void testLocalDateTime2Date() {

        LocalDateTime ldt = LocalDateTime.of(2017, 10, 29, 10, 15, 30);

        Calendar calOld = Calendar.getInstance();
        calOld.set(2017, 9, 29, 10, 15, 30);
        calOld.set(Calendar.MILLISECOND, 0);
        Date dateOld = calOld.getTime();

        assertThat(DateUtils.localDateTime2Date(ldt), is(dateOld));

        Calendar calOld2 = Calendar.getInstance();
        calOld2.set(2017, 9, 29, 10, 15, 30);
        calOld2.set(Calendar.MILLISECOND, 0);
        calOld2.setTimeZone(TimeZone.getTimeZone("GMT"));
        Date dateOld2 = new Date(calOld2.getTimeInMillis());

        assertThat(DateUtils.localDateTime2Date(ldt), is(not(dateOld2)));

    }

    @Test
    public void testDate2LocalDateTime() {

        LocalDateTime ldt = LocalDateTime.of(2017, 10, 29, 10, 15, 30);

        Calendar calOld = Calendar.getInstance();
        calOld.set(2017, 9, 29, 10, 15, 30);
        calOld.set(Calendar.MILLISECOND, 0);
        Date dateOld = calOld.getTime();

        assertThat(DateUtils.date2LocalDateTime(dateOld), is(ldt));

        Calendar calOld2 = Calendar.getInstance();
        calOld2.set(2017, 9, 29, 10, 15, 30);
        calOld2.set(Calendar.MILLISECOND, 0);
        calOld2.setTimeZone(TimeZone.getTimeZone("GMT"));
        Date dateOld2 = calOld2.getTime();

        assertThat(DateUtils.date2LocalDateTime(dateOld2), is(not(ldt)));
    }

}
