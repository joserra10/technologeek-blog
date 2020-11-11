/**
 * Technologeek Soft 10 nov 2020
 */
package mx.technologeek.user.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Error al no encontrar el usuario.
 * 
 * @author rsalas - Technologeek Soft
 */
@ResponseStatus(code = HttpStatus.NO_CONTENT, reason = "User not found.")
public class UserNotFoundException extends ServiceExecutionException {

    /**
     * 
     */
    private static final long serialVersionUID = -5867876478478967561L;

    /**
     * @param message Mensaje de error.
     * @param error Error.
     */
    public UserNotFoundException(final CharSequence message,
            final Throwable error) {
        super(message.toString(), error);
    }

    /**
     * @param message Mensaje de error.
     */
    public UserNotFoundException(final CharSequence message) {
        super(message.toString());
    }

}
