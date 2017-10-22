package io.github.anego.utils;

import java.math.BigDecimal;
import junit.framework.TestCase;
import org.junit.Test;

@SuppressWarnings("javadoc")
public class NumberUtilsTest extends TestCase {

    @Test
    public void testIsEmptyShort() {
        assertTrue(NumberUtils.isEmpty((Short) null));
        assertTrue(NumberUtils.isEmpty(Short.valueOf(Short.MIN_VALUE)));
        assertTrue(NumberUtils.isEmpty(Short.valueOf((short) -1)));
        assertFalse(NumberUtils.isEmpty(Short.valueOf((short) 0)));
        assertFalse(NumberUtils.isEmpty(Short.valueOf((short) 1)));
        assertFalse(NumberUtils.isEmpty(Short.valueOf(Short.MAX_VALUE)));
    }

    @Test
    public void testIsEmptyInteger() {
        assertTrue(NumberUtils.isEmpty((Integer) null));
        assertTrue(NumberUtils.isEmpty(Integer.valueOf(Integer.MIN_VALUE)));
        assertTrue(NumberUtils.isEmpty(Integer.valueOf((short) -1)));
        assertFalse(NumberUtils.isEmpty(Integer.valueOf((short) 0)));
        assertFalse(NumberUtils.isEmpty(Integer.valueOf((short) 1)));
        assertFalse(NumberUtils.isEmpty(Integer.valueOf(Integer.MAX_VALUE)));
    }

    @Test
    public void testIsEmptyLong() {
        assertTrue(NumberUtils.isEmpty((Long) null));
        assertTrue(NumberUtils.isEmpty(Long.valueOf(Long.MIN_VALUE)));
        assertTrue(NumberUtils.isEmpty(Long.valueOf((short) -1)));
        assertFalse(NumberUtils.isEmpty(Long.valueOf((short) 0)));
        assertFalse(NumberUtils.isEmpty(Long.valueOf((short) 1)));
        assertFalse(NumberUtils.isEmpty(Long.valueOf(Long.MAX_VALUE)));
    }

    @Test
    public void testIsNotEmptyShort() {
        assertFalse(NumberUtils.isNotEmpty((Short) null));
        assertFalse(NumberUtils.isNotEmpty(Short.valueOf(Short.MIN_VALUE)));
        assertFalse(NumberUtils.isNotEmpty(Short.valueOf((short) -1)));
        assertTrue(NumberUtils.isNotEmpty(Short.valueOf((short) 0)));
        assertTrue(NumberUtils.isNotEmpty(Short.valueOf((short) 1)));
        assertTrue(NumberUtils.isNotEmpty(Short.valueOf(Short.MAX_VALUE)));
    }

    @Test
    public void testIsNotEmptyInteger() {
        assertFalse(NumberUtils.isNotEmpty((Integer) null));
        assertFalse(NumberUtils.isNotEmpty(Integer.valueOf(Integer.MIN_VALUE)));
        assertFalse(NumberUtils.isNotEmpty(Integer.valueOf((short) -1)));
        assertTrue(NumberUtils.isNotEmpty(Integer.valueOf((short) 0)));
        assertTrue(NumberUtils.isNotEmpty(Integer.valueOf((short) 1)));
        assertTrue(NumberUtils.isNotEmpty(Integer.valueOf(Integer.MAX_VALUE)));
    }

    @Test
    public void testIsNotEmptyLong() {
        assertFalse(NumberUtils.isNotEmpty((Long) null));
        assertFalse(NumberUtils.isNotEmpty(Long.valueOf(Long.MIN_VALUE)));
        assertFalse(NumberUtils.isNotEmpty(Long.valueOf((short) -1)));
        assertTrue(NumberUtils.isNotEmpty(Long.valueOf((short) 0)));
        assertTrue(NumberUtils.isNotEmpty(Long.valueOf((short) 1)));
        assertTrue(NumberUtils.isNotEmpty(Long.valueOf(Long.MAX_VALUE)));
    }

    @Test
    public void testIsBlankLong() {
        assertTrue(NumberUtils.isBlank((Long) null));
        assertTrue(NumberUtils.isBlank(Long.valueOf(Long.MIN_VALUE)));
        assertTrue(NumberUtils.isBlank(Long.valueOf(-1)));
        assertTrue(NumberUtils.isBlank(Long.valueOf(0)));
        assertFalse(NumberUtils.isBlank(Long.valueOf(1)));
        assertFalse(NumberUtils.isBlank(Long.valueOf(Long.MAX_VALUE)));
    }

    @Test
    public void testIsBlankInteger() {
        assertTrue(NumberUtils.isBlank((Integer) null));
        assertTrue(NumberUtils.isBlank(Integer.valueOf(Integer.MIN_VALUE)));
        assertTrue(NumberUtils.isBlank(Integer.valueOf(-1)));
        assertTrue(NumberUtils.isBlank(Integer.valueOf(0)));
        assertFalse(NumberUtils.isBlank(Integer.valueOf(1)));
        assertFalse(NumberUtils.isBlank(Integer.valueOf(Integer.MAX_VALUE)));
    }

    @Test
    public void testIsBlankShort() {
        assertTrue(NumberUtils.isBlank((Short) null));
        assertTrue(NumberUtils.isBlank(Short.valueOf(Short.MIN_VALUE)));
        assertTrue(NumberUtils.isBlank(Short.valueOf((short) -1)));
        assertTrue(NumberUtils.isBlank(Short.valueOf((short) 0)));
        assertFalse(NumberUtils.isBlank(Short.valueOf((short) 1)));
        assertFalse(NumberUtils.isBlank(Short.valueOf(Short.MAX_VALUE)));
    }

    @Test
    public void testIsNotBlankLong() {
        assertFalse(NumberUtils.isNotBlank((Long) null));
        assertFalse(NumberUtils.isNotBlank(Long.valueOf(Long.MIN_VALUE)));
        assertFalse(NumberUtils.isNotBlank(Long.valueOf(-1)));
        assertFalse(NumberUtils.isNotBlank(Long.valueOf(0)));
        assertTrue(NumberUtils.isNotBlank(Long.valueOf(1)));
        assertTrue(NumberUtils.isNotBlank(Long.valueOf(Long.MAX_VALUE)));
    }

    @Test
    public void testIsNotBlankInteger() {
        assertFalse(NumberUtils.isNotBlank((Integer) null));
        assertFalse(NumberUtils.isNotBlank(Integer.valueOf(Integer.MIN_VALUE)));
        assertFalse(NumberUtils.isNotBlank(Integer.valueOf(-1)));
        assertFalse(NumberUtils.isNotBlank(Integer.valueOf(0)));
        assertTrue(NumberUtils.isNotBlank(Integer.valueOf(1)));
        assertTrue(NumberUtils.isNotBlank(Integer.valueOf(Integer.MAX_VALUE)));
    }

    @Test
    public void testIsNotBlankShort() {
        assertFalse(NumberUtils.isNotBlank((Short) null));
        assertFalse(NumberUtils.isNotBlank(Short.valueOf(Short.MIN_VALUE)));
        assertFalse(NumberUtils.isNotBlank(Short.valueOf((short) -1)));
        assertFalse(NumberUtils.isNotBlank(Short.valueOf((short) 0)));
        assertTrue(NumberUtils.isNotBlank(Short.valueOf((short) 1)));
        assertTrue(NumberUtils.isNotBlank(Short.valueOf(Short.MAX_VALUE)));
    }

    @Test
    public void testToIntString() {
        assertEquals(NumberUtils.toInt((String) null), 0);
        assertEquals(NumberUtils.toInt(""), 0);
        assertEquals(NumberUtils.toInt("1"), 1);
        assertEquals(NumberUtils.toInt("１"), 1);
        assertEquals(NumberUtils.toInt("" + Integer.MIN_VALUE), Integer.MIN_VALUE);
        assertEquals(NumberUtils.toInt("" + Integer.MAX_VALUE), Integer.MAX_VALUE);
        assertEquals(NumberUtils.toInt("" + Short.MAX_VALUE), Short.MAX_VALUE);
        assertEquals(NumberUtils.toInt("" + Long.MIN_VALUE), Integer.MIN_VALUE);
        assertEquals(NumberUtils.toInt("" + Long.MAX_VALUE), Integer.MAX_VALUE);
        assertEquals(NumberUtils.toInt("a"), 0);
    }

    @Test
    public void testToIntShort() {
        assertEquals(NumberUtils.toInt((Short) null), 0);
        assertEquals(NumberUtils.toInt(Short.valueOf(Short.MIN_VALUE)), Short.MIN_VALUE);
        assertEquals(NumberUtils.toInt(Short.valueOf(Short.MAX_VALUE)), Short.MAX_VALUE);
    }

    @Test
    public void testToIntShortInt() {
        assertEquals(NumberUtils.toInt((Short) null, 0), 0);
        assertEquals(NumberUtils.toInt(Short.valueOf((short) 1), 0), 1);

    }

    @Test
    public void testToIntInteger() {
        assertEquals(NumberUtils.toInt((Integer) null), 0);
        assertEquals(NumberUtils.toInt(Integer.valueOf(1)), 1);
    }

    @Test
    public void testToIntIntegerInt() {
        assertEquals(NumberUtils.toInt((Integer) null, 1), 1);
        assertEquals(NumberUtils.toInt(Integer.valueOf(1), 0), 1);
    }

    @Test
    public void testToIntLong() {
        assertEquals(NumberUtils.toInt((Long) null), 0);
        assertEquals(NumberUtils.toInt(Long.valueOf(1)), 1);
    }

    @Test
    public void testToIntLongInt() {
        assertEquals(NumberUtils.toInt((Long) null, 1), 1);
        assertEquals(NumberUtils.toInt(Long.valueOf(1), 0), 1);
    }

    @Test
    public void testToIntBoolean() {
        assertEquals(NumberUtils.toInt((Boolean) null), 0);
        assertEquals(NumberUtils.toInt(Boolean.FALSE), 0);
        assertEquals(NumberUtils.toInt(Boolean.TRUE), 1);
    }

    @Test
    public void testToShortByte() {
        assertNull(NumberUtils.toShort((Byte) null));
        assertEquals(NumberUtils.toShort(Byte.valueOf((byte) 1)), Short.valueOf((short) 1));
    }

    @Test
    public void testToShortInt() {
        assertEquals(NumberUtils.toShort(0), Short.valueOf((short) 0));
        assertEquals(NumberUtils.toShort(1), Short.valueOf((short) 1));
        assertEquals(NumberUtils.toShort(Integer.valueOf(Integer.MAX_VALUE)),
                Short.valueOf(Short.MAX_VALUE));
        assertEquals(NumberUtils.toShort(Integer.valueOf(Integer.MIN_VALUE)),
                Short.valueOf(Short.MIN_VALUE));
    }

    @Test
    public void testToShortShortInt() {
        assertEquals(NumberUtils.toShort((Short) null, 0), Short.valueOf((short) 0));
        assertEquals(NumberUtils.toShort((Short) null, 1), Short.valueOf((short) 1));
        assertEquals(NumberUtils.toShort(Short.valueOf((short) 1), 0), Short.valueOf((short) 1));
    }

    @Test
    public void testToShortInteger() {
        assertEquals(NumberUtils.toShort((Integer) null), Short.valueOf((short) 0));
        assertEquals(NumberUtils.toShort(Integer.valueOf(1)), Short.valueOf((short) 1));
        assertEquals(NumberUtils.toShort(Integer.valueOf(Integer.MAX_VALUE)),
                Short.valueOf(Short.MAX_VALUE));
        assertEquals(NumberUtils.toShort(Integer.valueOf(Integer.MIN_VALUE)),
                Short.valueOf(Short.MIN_VALUE));
    }

    @Test
    public void testToShortIntegerShort() {
        assertEquals(NumberUtils.toShort((Integer) null, (short) 0), Short.valueOf((short) 0));
        assertEquals(NumberUtils.toShort((Integer) null, (short) 1), Short.valueOf((short) 1));
        assertEquals(NumberUtils.toShort(Integer.valueOf(1), (short) 0), Short.valueOf((short) 1));
        assertEquals(NumberUtils.toShort(Integer.valueOf(Integer.MAX_VALUE), (short) 0),
                Short.valueOf(Short.MAX_VALUE));
        assertEquals(NumberUtils.toShort(Integer.valueOf(Integer.MIN_VALUE), (short) 0),
                Short.valueOf(Short.MIN_VALUE));
    }

    @Test
    public void testToShortLong() {
        assertNull(NumberUtils.toShort((Long) null));
        assertEquals(NumberUtils.toShort(Long.valueOf(1)), Short.valueOf((short) 1));
        assertEquals(NumberUtils.toShort(Long.valueOf(Long.MAX_VALUE)),
                Short.valueOf(Short.MAX_VALUE));
        assertEquals(NumberUtils.toShort(Long.valueOf(Long.MIN_VALUE)),
                Short.valueOf(Short.MIN_VALUE));
    }

    @Test
    public void testToShortLong1() {
        assertEquals(NumberUtils.toShort(0L), Short.valueOf((short) 0));
        assertEquals(NumberUtils.toShort(1L), Short.valueOf((short) 1));
        assertEquals(NumberUtils.toShort(Long.MAX_VALUE), Short.valueOf(Short.MAX_VALUE));
        assertEquals(NumberUtils.toShort(Long.MIN_VALUE), Short.valueOf(Short.MIN_VALUE));

    }

    @Test
    public void testToShortString() {
        assertNull(NumberUtils.toShort((String) null));
        assertNull(NumberUtils.toShort(""));
        assertEquals(NumberUtils.toShort("0"), Short.valueOf((short) 0));
        assertEquals(NumberUtils.toShort("1"), Short.valueOf((short) 1));
        assertEquals(NumberUtils.toShort("１"), Short.valueOf((short) 1));
        assertEquals(NumberUtils.toShort("" + Integer.MIN_VALUE), Short.valueOf(Short.MIN_VALUE));
        assertEquals(NumberUtils.toShort("" + Integer.MAX_VALUE), Short.valueOf(Short.MAX_VALUE));
        assertNull(NumberUtils.toShort("a"));

    }

    @Test
    public void testToShortStringInt() {
        assertEquals(NumberUtils.toShort((String) null, 0), Short.valueOf((short) 0));
        assertEquals(NumberUtils.toShort((String) null, 1), Short.valueOf((short) 1));
        assertEquals(NumberUtils.toShort("", 0), Short.valueOf((short) 0));
        assertEquals(NumberUtils.toShort("", 1), Short.valueOf((short) 1));
        assertEquals(NumberUtils.toShort("0", 0), Short.valueOf((short) 0));
        assertEquals(NumberUtils.toShort("1", 0), Short.valueOf((short) 1));
        assertEquals(NumberUtils.toShort("１", 0), Short.valueOf((short) 1));
        assertEquals(NumberUtils.toShort("" + Integer.MIN_VALUE, 0),
                Short.valueOf(Short.MIN_VALUE));
        assertEquals(NumberUtils.toShort("" + Integer.MAX_VALUE, 0),
                Short.valueOf(Short.MAX_VALUE));
        assertEquals(NumberUtils.toShort("a", 0), Short.valueOf((short) 0));
        assertEquals(NumberUtils.toShort("a", 1), Short.valueOf((short) 1));

    }

    @Test
    public void testToIntegerShortInt() {
        assertEquals(NumberUtils.toInteger((Short) null, 0), Integer.valueOf(0));
        assertEquals(NumberUtils.toInteger((Short) null, 1), Integer.valueOf(1));
        assertEquals(NumberUtils.toInteger(Short.valueOf((short) 1), 0), Integer.valueOf(1));
        assertEquals(NumberUtils.toInteger(Short.valueOf(Short.MIN_VALUE), 0),
                Integer.valueOf(Short.MIN_VALUE));
        assertEquals(NumberUtils.toInteger(Short.valueOf(Short.MAX_VALUE), 0),
                Integer.valueOf(Short.MAX_VALUE));
    }

    @Test
    public void testToIntegerIntegerInt() {
        assertEquals(NumberUtils.toInteger((Integer) null, 0), Integer.valueOf(0));
        assertEquals(NumberUtils.toInteger((Integer) null, 1), Integer.valueOf(1));
        assertEquals(NumberUtils.toInteger(Integer.valueOf(1), 0), Integer.valueOf(1));

    }

    @Test
    public void testToIntegerLong() {
        assertEquals(NumberUtils.toInteger(0L), Integer.valueOf(0));
        assertEquals(NumberUtils.toInteger(Long.MIN_VALUE), Integer.valueOf(Integer.MIN_VALUE));
        assertEquals(NumberUtils.toInteger(Long.MAX_VALUE), Integer.valueOf(Integer.MAX_VALUE));
    }

    @Test
    public void testToIntegerLong1() {
        assertNull(NumberUtils.toInteger((Long) null));
        assertEquals(NumberUtils.toInteger(Long.valueOf(0)), Integer.valueOf(0));
        assertEquals(NumberUtils.toInteger(Long.valueOf(1)), Integer.valueOf(1));
        assertEquals(NumberUtils.toInteger(Long.valueOf(Long.MIN_VALUE)),
                Integer.valueOf(Integer.MIN_VALUE));
        assertEquals(NumberUtils.toInteger(Long.valueOf(Long.MAX_VALUE)),
                Integer.valueOf(Integer.MAX_VALUE));
    }

    @Test
    public void testToIntegerString() {
        assertNull(NumberUtils.toInteger((String) null));
        assertNull(NumberUtils.toInteger(""));
        assertEquals(NumberUtils.toInteger("0"), Integer.valueOf(0));
        assertEquals(NumberUtils.toInteger("1"), Integer.valueOf(1));
        assertEquals(NumberUtils.toInteger("１"), Integer.valueOf(1));
        assertEquals(NumberUtils.toInteger("" + Long.MIN_VALUE),
                Integer.valueOf(Integer.MIN_VALUE));
        assertEquals(NumberUtils.toInteger("" + Long.MAX_VALUE),
                Integer.valueOf(Integer.MAX_VALUE));
        assertEquals(NumberUtils.toInteger("a"), Integer.valueOf(0));
    }

    @Test
    public void testToIntegerByte() {
        assertNull(NumberUtils.toInteger((Byte) null));
        assertEquals(NumberUtils.toInteger(Byte.valueOf((byte) 0)), Integer.valueOf(0));
        assertEquals(NumberUtils.toInteger(Byte.valueOf((byte) 1)), Integer.valueOf(1));
        assertEquals(NumberUtils.toInteger(Byte.valueOf(Byte.MIN_VALUE)),
                Integer.valueOf(Byte.MIN_VALUE));
        assertEquals(NumberUtils.toInteger(Byte.valueOf(Byte.MAX_VALUE)),
                Integer.valueOf(Byte.MAX_VALUE));
    }

    @Test
    public void testToIntegerShort() {
        assertNull(NumberUtils.toInteger((Short) null));
        assertEquals(NumberUtils.toInteger(Short.valueOf((short) 0)), Integer.valueOf(0));
        assertEquals(NumberUtils.toInteger(Short.valueOf((short) 1)), Integer.valueOf(1));
        assertEquals(NumberUtils.toInteger(Short.valueOf(Short.MIN_VALUE)),
                Integer.valueOf(Short.MIN_VALUE));
        assertEquals(NumberUtils.toInteger(Short.valueOf(Short.MAX_VALUE)),
                Integer.valueOf(Short.MAX_VALUE));
    }

    @Test
    public void testToIntegerBigDecimal() {
        assertNull(NumberUtils.toInteger((BigDecimal) null));
        assertEquals(NumberUtils.toInteger(BigDecimal.valueOf(0L)), Integer.valueOf(0));
        assertEquals(NumberUtils.toInteger(BigDecimal.valueOf(1L)), Integer.valueOf(1));
        assertEquals(NumberUtils.toInteger(BigDecimal.valueOf(Long.MIN_VALUE)),
                Integer.valueOf(Integer.MIN_VALUE));
        assertEquals(NumberUtils.toInteger(BigDecimal.valueOf(Long.MAX_VALUE)),
                Integer.valueOf(Integer.MAX_VALUE));
    }

    @Test
    public void testToLongInteger() {
        assertNull(NumberUtils.toLong((Integer) null));
        assertEquals(NumberUtils.toLong(Integer.valueOf(0)), Long.valueOf(0));
        assertEquals(NumberUtils.toLong(Integer.valueOf(1)), Long.valueOf(1));
        assertEquals(NumberUtils.toLong(Integer.valueOf(Integer.MIN_VALUE)),
                Long.valueOf(Integer.MIN_VALUE));
        assertEquals(NumberUtils.toLong(Integer.valueOf(Integer.MAX_VALUE)),
                Long.valueOf(Integer.MAX_VALUE));
    }

    @Test
    public void testToLongString() {
        assertNull(NumberUtils.toLong((String) null));
        assertNull(NumberUtils.toLong(""));
        assertEquals(NumberUtils.toLong("0"), Long.valueOf(0L));
        assertEquals(NumberUtils.toLong("1"), Long.valueOf(1L));
        assertEquals(NumberUtils.toLong("１"), Long.valueOf(1L));
        assertEquals(NumberUtils.toLong("" + Long.MIN_VALUE), Long.valueOf(Long.MIN_VALUE));
        assertEquals(NumberUtils.toLong("" + Long.MAX_VALUE), Long.valueOf(Long.MAX_VALUE));
        assertNull(NumberUtils.toLong("a"));
    }

    @Test
    public void testToByte() {
        assertNull(NumberUtils.toByte((Short) null));
        assertEquals(NumberUtils.toByte(Short.valueOf((short) 0)), Byte.valueOf((byte) 0));
        assertEquals(NumberUtils.toByte(Short.valueOf((short) 1)), Byte.valueOf((byte) 1));
        assertEquals(NumberUtils.toByte(Short.valueOf(Short.MIN_VALUE)),
                Byte.valueOf(Byte.MIN_VALUE));
        assertEquals(NumberUtils.toByte(Short.valueOf(Short.MAX_VALUE)),
                Byte.valueOf(Byte.MAX_VALUE));
    }

    @Test
    public void testToFloat() {
        assertEquals(NumberUtils.toFloat((String) null), 0f, 0f);
        assertEquals(NumberUtils.toFloat(""), 0f, 0f);
        assertEquals(NumberUtils.toFloat("1"), 1f, 0f);
        assertEquals(NumberUtils.toFloat("１"), 1f, 0f);
        assertEquals(NumberUtils.toFloat("" + Double.MIN_VALUE), Float.MIN_VALUE, 0f);
        assertEquals(NumberUtils.toFloat("" + Double.MAX_VALUE), Float.MAX_VALUE, 0f);
        assertEquals(NumberUtils.toFloat("a"), 0f, 0f);
    }

    // @Test
    // public void testToDouble() {
    // fail("まだ実装されていません");
    // }
    //
    // @Test
    // public void testIsInteger() {
    // fail("まだ実装されていません");
    // }
    //
    // @Test
    // public void testIsLong() {
    // fail("まだ実装されていません");
    // }
    //
    // @Test
    // public void testDecimalScale() {
    // fail("まだ実装されていません");
    // }
    //
    // @Test
    // public void testObject() {
    // fail("まだ実装されていません");
    // }
    //
    // @Test
    // public void testGetClass() {
    // fail("まだ実装されていません");
    // }
    //
    // @Test
    // public void testHashCode() {
    // fail("まだ実装されていません");
    // }
    //
    // @Test
    // public void testEquals() {
    // fail("まだ実装されていません");
    // }
    //
    // @Test
    // public void testClone() {
    // fail("まだ実装されていません");
    // }
    //
    // @Test
    // public void testToString() {
    // fail("まだ実装されていません");
    // }
    //
    // @Test
    // public void testNotify() {
    // fail("まだ実装されていません");
    // }
    //
    // @Test
    // public void testNotifyAll() {
    // fail("まだ実装されていません");
    // }
    //
    // @Test
    // public void testWaitLong() {
    // fail("まだ実装されていません");
    // }
    //
    // @Test
    // public void testWaitLongInt() {
    // fail("まだ実装されていません");
    // }
    //
    // @Test
    // public void testWait() {
    // fail("まだ実装されていません");
    // }
    //
    // @Test
    // public void testFinalize() {
    // fail("まだ実装されていません");
    // }

}
