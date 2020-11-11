/**
 * Technologeek Soft 10 nov 2020
 */
package mx.technologeek.user.service.exception;

/**
 * Error en el servicio.
 * 
 * @author rsalas - Technologeek Soft
 */
public class ServiceExecutionException extends Exception {

    /**
     * 
     */
    private static final long serialVersionUID = 7179268381869056447L;

    /**
     * Error en la ejecuci&oacute;n del servicio.
     * 
     * @param message Mensaje de error.
     * @param error Error.
     */
    public ServiceExecutionException(final CharSequence message,
            final Throwable error) {
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
