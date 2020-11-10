/**
 * Technologeek Soft 9 nov 2020
 */
package mx.technologeek.blog.service.exception;

/**
 * Unit tests for the exception class {@link BlogUpdateInternalError}.
 * 
 * @author rsalas - Technologeek Soft
 */
public class BlogUpdateInternalErrorTest
        extends AbstractExceptionTest<BlogUpdateInternalError> {

    /*
     * (non-Javadoc)
     * @see mx.technologeek.blog.service.exception.AbstractExceptionTest#
     * getMessageError(java.lang.String).
     */
    @Override
    protected BlogUpdateInternalError getMessageError(
            final String errorMessage) {
        return new BlogUpdateInternalError(errorMessage);
    }

    /*
     * (non-Javadoc)
     * @see mx.technologeek.blog.service.exception.AbstractExceptionTest#
     * getMessageExceptionError(java.lang.String, java.lang.Throwable).
     */
    @Override
    protected BlogUpdateInternalError getMessageExceptionError(
            final String errorMessage, final Throwable error) {
        return new BlogUpdateInternalError(errorMessage, error);
    }

}
