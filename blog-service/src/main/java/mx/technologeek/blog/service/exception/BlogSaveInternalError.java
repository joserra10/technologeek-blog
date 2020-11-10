/**
 * 
 */
package mx.technologeek.blog.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Error al momento de guardar el BLOG.
 * 
 * @author rsalas
 */
@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Could not save the blog.")
public class BlogSaveInternalError extends ServiceExecutionException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6693608161515955202L;

	/**
	 * @param message Mensaje de error.
	 * @param error   Error.
	 */
	public BlogSaveInternalError(final CharSequence message, final Throwable error) {
		super(message.toString(), error);
	}

	/**
	 * @param message Mensaje de error.
	 */
	public BlogSaveInternalError(final CharSequence message) {
		super(message.toString());
	}

}
