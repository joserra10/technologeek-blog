/**
 * Technologeek Soft 10 nov 2020
 */
package mx.technologeek.user.service.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.technologeek.blog.data.dto.UserDTO;
import mx.technologeek.user.service.client.UserDataClient;
import mx.technologeek.user.service.exception.ServiceExecutionException;
import mx.technologeek.user.service.exception.UserNotFoundException;

/**
 * Implementaci&oacute;n de la interfaz {@link UserSearchService}.
 * <p>
 * Servicio para buscar a un usuario.
 * 
 * @author rsalas - Technologeek Soft
 */
@Service
public class UserSearchServiceImpl implements UserSearchService {

    /** the client. */
    @Autowired
    private UserDataClient client;

    /*
     * (non-Javadoc)
     * @see
     * mx.technologeek.user.service.business.UserSearchService#findByEmail(java.
     * lang.String).
     */
    @Override
    public UserDTO findByEmail(final String email)
            throws ServiceExecutionException {
        final UserDTO userDTO = client.findByEmail(email);
        if (userDTO == null) {
            throw new UserNotFoundException("El usuario con correo electronico "
                    + email + " no existe");
        }
        return userDTO;
    }

}
