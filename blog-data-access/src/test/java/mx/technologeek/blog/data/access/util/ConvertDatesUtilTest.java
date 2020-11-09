/**
 * Technologeek Soft 9 nov 2020
 */
package mx.technologeek.blog.data.access.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

/**
 * Unit tests from the util {@link ConvertDatesUtil}.
 * 
 * @author rsalas - Technologeek Soft
 */
public class ConvertDatesUtilTest {

    /**
     * Success test.
     * <p>
     * Helper that converts a {@link Date} in {@link LocalDateTime}.
     */
    @Test
    public void localDateTimeTest() {
        final LocalDateTime result = ConvertDatesUtil
                .convert(Calendar.getInstance().getTime());
        Assert.assertTrue(result.toLocalDate().isEqual(LocalDate.now()));
    }

    /**
     * Success test.
     * <p>
     * Test with a null date.
     */
    @Test
    public void localDateTimeNullTest() {
        Date nullTime = null;
        Assert.assertNull(ConvertDatesUtil.convert(nullTime));
    }

    /**
     * Success test.
     * <p>
     * Helper that converts a {@link LocalDateTime} to {@link Date}.
     */
    @Test
    public void dateTest() {
        final Date result = ConvertDatesUtil.convert(LocalDateTime.now());
        Assert.assertNotNull(result);
    }

    /**
     * Success test.
     * <p>
     * Test with a null date.
     */
    @Test
    public void dateNullTest() {
        final LocalDateTime nullVal = null;
        Assert.assertNull(ConvertDatesUtil.convert(nullVal));
    }

}
