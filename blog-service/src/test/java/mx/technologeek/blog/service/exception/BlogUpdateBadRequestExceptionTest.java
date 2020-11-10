/**
 * Technologeek Soft 9 nov 2020
 */
package mx.technologeek.blog.service.exception;

/**
 * Unit tests of the exception class {@link BlogUpdateBadRequestException}.
 * 
 * @author rsalas - Technologeek Soft
 */
public class BlogUpdateBadRequestExceptionTest
        extends AbstractExceptionTest<BlogUpdateBadRequestException> {

    /*
     * (non-Javadoc)
     * @see mx.technologeek.blog.service.exception.AbstractExceptionTest#
     * getMessageError(java.lang.String).
     */
    @Override
    protected BlogUpdateBadRequestException getMessageError(
            final String errorMessage) {
        return new BlogUpdateBadRequestException(errorMessage);
    }

    /*
     * (non-Javadoc)
     * @see mx.technologeek.blog.service.exception.AbstractExceptionTest#
     * getMessageExceptionError(java.lang.String, java.lang.Throwable).
     */
    @Override
    protected BlogUpdateBadRequestException getMessageExceptionError(
            final String errorMessage, final Throwable error) {
        return new BlogUpdateBadRequestException(errorMessage, error);
    }

}
