/**
 * 
 */
package mx.technologeek.blog.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Error interno en la actualizaci&oacute;n del blog.
 * 
 * @author rsalas
 */
@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Could not update the blog.")
public class BlogUpdateInternalError extends ServiceExecutionException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1364031766036096868L;

	/**
	 * @param message Mensaje de error.
	 * @param error   Error.
	 */
	public BlogUpdateInternalError(final CharSequence message, final Throwable error) {
		super(message, error);
	}

	/**
	 * @param message Mensaje de error.
	 */
	public BlogUpdateInternalError(final CharSequence message) {
		super(message);
	}

}
