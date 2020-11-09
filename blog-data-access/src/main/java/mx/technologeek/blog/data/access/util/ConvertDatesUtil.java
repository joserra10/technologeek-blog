/**
 * Technologeek Soft 9 nov 2020
 */
package mx.technologeek.blog.data.access.util;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * Utileria para convertir de {@link Date} a {@link LocalDateTime} y vicebersa.
 * 
 * @author rsalas - Technologeek Soft
 */
public final class ConvertDatesUtil {

    /** Default constructor. */
    private ConvertDatesUtil() {
    }

    /**
     * Convierte de {@link Date} a {@link LocalDateTime}.
     * 
     * @param date {@link Date}.
     * @return {@link LocalDateTime}.
     */
    public static LocalDateTime convert(final Date date) {
        return (date != null)
                ? Instant.ofEpochMilli(date.getTime())
                        .atZone(ZoneId.systemDefault()).toLocalDateTime()
                : null;
    }

    /**
     * Convierte de {@link LocalDateTime} a {@link Date}.
     * 
     * @param localDateTime {@link LocalDateTime}.
     * @return {@link Date}.
     */
    public static Date convert(final LocalDateTime localDateTime) {
        return (localDateTime != null)
                ? Date.from(localDateTime.atZone(ZoneId.systemDefault())
                        .toInstant())
                : null;
    }

}
