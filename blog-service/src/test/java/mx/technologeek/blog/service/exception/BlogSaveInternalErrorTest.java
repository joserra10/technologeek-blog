/**
 * Technologeek Soft 9 nov 2020
 */
package mx.technologeek.blog.service.exception;

/**
 * Unit tests of the class {@link BlogSaveInternalError}.
 * 
 * @author rsalas - Technologeek Soft
 */
public class BlogSaveInternalErrorTest
        extends AbstractExceptionTest<BlogSaveInternalError> {

    /*
     * (non-Javadoc)
     * @see mx.technologeek.blog.service.exception.AbstractExceptionTest#
     * getMessageError(java.lang.String).
     */
    @Override
    protected BlogSaveInternalError getMessageError(final String errorMessage) {
        return new BlogSaveInternalError(errorMessage);
    }

    /*
     * (non-Javadoc)
     * @see mx.technologeek.blog.service.exception.AbstractExceptionTest#
     * getMessageExceptionError(java.lang.String, java.lang.Throwable).
     */
    @Override
    protected BlogSaveInternalError getMessageExceptionError(
            final String errorMessage, final Throwable error) {
        return new BlogSaveInternalError(errorMessage, error);
    }

}
