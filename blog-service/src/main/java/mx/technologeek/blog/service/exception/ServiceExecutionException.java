/**
 * 
 */
package mx.technologeek.blog.service.exception;

/**
 * Error en la ejecuci&oacute;n del servicio.
 * 
 * @author rsalas
 */
public class ServiceExecutionException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7309894464881212491L;

	/**
	 * Error en la ejecuci&oacute;n del servicio.
	 * 
	 * @param message Mensaje de error.
	 * @param error   Error.
	 */
	public ServiceExecutionException(final CharSequence message, final Throwable error) {
		super(message.toString(), error);
	}

	/**
	 * Error en la ejecuci&oacute;n del servicio.
	 * 
	 * @param message Mensaje de error.
	 */
	public ServiceExecutionException(final CharSequence message) {
		super(message.toString());
	}

}
