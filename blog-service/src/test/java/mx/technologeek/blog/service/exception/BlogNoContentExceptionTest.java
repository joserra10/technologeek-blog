/**
 * Technologeek Soft 9 nov 2020
 */
package mx.technologeek.blog.service.exception;

/**
 * Unit tests of the class {@link BlogNoContentException}.
 * 
 * @author rsalas - Technologeek Soft
 */
public class BlogNoContentExceptionTest
        extends AbstractExceptionTest<BlogNoContentException> {

    /*
     * (non-Javadoc)
     * @see mx.technologeek.blog.service.exception.AbstractExceptionTest#
     * getMessageError(java.lang.String).
     */
    @Override
    protected BlogNoContentException getMessageError(
            final String errorMessage) {
        return new BlogNoContentException(errorMessage);
    }

    /*
     * (non-Javadoc)
     * @see mx.technologeek.blog.service.exception.AbstractExceptionTest#
     * getMessageExceptionError(java.lang.String, java.lang.Throwable).
     */
    @Override
    protected BlogNoContentException getMessageExceptionError(
            final String errorMessage, final Throwable error) {
        return new BlogNoContentException(errorMessage, error);
    }

}
