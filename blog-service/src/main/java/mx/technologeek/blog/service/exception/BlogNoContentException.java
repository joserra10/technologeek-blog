/**
 * 
 */
package mx.technologeek.blog.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Error cuando no hay informaci&oacute;n de los blogs.
 * 
 * @author rsalas
 */
@ResponseStatus(code = HttpStatus.NO_CONTENT, reason = "Empty result")
public class BlogNoContentException extends ServiceExecutionException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -857274690663918462L;

	/**
	 * Error en la consulta del BLOG.
	 * 
	 * @param message Mensaje de error.
	 * @param error   Error.
	 */
	public BlogNoContentException(final CharSequence message, final Throwable error) {
		super(message, error);
	}

	/**
	 * Error en la consulta del BLOG.
	 * 
	 * @param message Mensaje de error.
	 */
	public BlogNoContentException(final CharSequence message) {
		super(message);
	}

}
