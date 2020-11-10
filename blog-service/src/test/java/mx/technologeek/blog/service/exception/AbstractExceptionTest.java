/**
 * Technologeek Soft 9 nov 2020
 */
package mx.technologeek.blog.service.exception;

import org.junit.Assert;
import org.junit.Test;

/**
 * Unit test to execute a test of the project exceptions.
 * 
 * @author rsalas - Technologeek Soft
 * @param <E> Exception.
 */
public abstract class AbstractExceptionTest<E extends ServiceExecutionException> {

    /**
     * Throw an exception with an error message.
     */
    @Test
    public void messageErrorTest() {
        try {
            throw getMessageError("Error");
        } catch (ServiceExecutionException ex) {
            Assert.assertTrue(ex.getMessage().equals("Error"));
        }
    }

    /**
     * Throw an exception with an error message and a throwable.
     */
    @Test
    public void messageExceptionAndErrorTest() {
        try {
            throw getMessageExceptionError("Error", new NullPointerException());
        } catch (ServiceExecutionException ex) {
            Assert.assertTrue(ex.getLocalizedMessage().equals("Error"));
            Assert.assertTrue(ex.getCause() instanceof NullPointerException);
        }
    }

    /**
     * Obtain the exception with a error message.
     * 
     * @param errorMessage the error message.
     * @return Exception.
     */
    protected abstract E getMessageError(String errorMessage);

    /**
     * Otain the exception with throwable and a error message.
     * 
     * @param errorMessage Error message.
     * @param error Throwable.
     * @return Exception
     */
    protected abstract E getMessageExceptionError(String errorMessage,
            Throwable error);

}
