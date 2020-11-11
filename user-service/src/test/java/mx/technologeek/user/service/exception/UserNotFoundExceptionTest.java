/**
 * Technologeek Soft 10 nov 2020
 */
package mx.technologeek.user.service.exception;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Unit tests of the exception class {@link UserNotFoundException}.
 * 
 * @author rsalas - Technologeek Soft
 */
class UserNotFoundExceptionTest {

    /**
     * Test that throw an exception with exception instance and an error
     * message.
     */
    @Test
    void exceptionAndErrorTest() {
        try {
            throw new UserNotFoundException("Error",
                    new NullPointerException());
        } catch (ServiceExecutionException e) {
            Assertions.assertAll(() -> Assertions.assertNotNull(e),
                    () -> Assertions
                            .assertTrue(e instanceof UserNotFoundException),
                    () -> Assertions.assertEquals("Error", e.getMessage()),
                    () -> Assertions.assertNotNull(e.getCause()),
                    () -> Assertions.assertTrue(
                            e.getCause() instanceof NullPointerException));
        }
    }

    /**
     * Test that throw an exception with an error message.
     */
    @Test
    void errorTest() {
        try {
            throw new UserNotFoundException("Error");
        } catch (ServiceExecutionException e) {
            Assertions.assertAll(() -> Assertions.assertNotNull(e),
                    () -> Assertions
                            .assertTrue(e instanceof UserNotFoundException),
                    () -> Assertions.assertEquals("Error", e.getMessage()));
        }
    }

}
