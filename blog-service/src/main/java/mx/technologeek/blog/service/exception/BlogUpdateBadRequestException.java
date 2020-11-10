/**
 * 
 */
package mx.technologeek.blog.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Error en la request para la actualizaci&oacute;n del BLOG.
 * 
 * @author rsalas
 */
@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Information is not completed.")
public class BlogUpdateBadRequestException extends ServiceExecutionException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7256922025088039110L;

	/**
	 * @param message Mensaje de error.
	 * @param error   Error.
	 */
	public BlogUpdateBadRequestException(final CharSequence message, final Throwable error) {
		super(message.toString(), error);
	}

	/**
	 * @param message Mensaje de error.
	 */
	public BlogUpdateBadRequestException(final CharSequence message) {
		super(message.toString());
	}

}
